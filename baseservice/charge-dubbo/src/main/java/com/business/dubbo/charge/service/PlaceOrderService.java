package com.business.dubbo.charge.service;

import com.business.api.entity.*;
import com.business.api.entity.enumtype.AccountStatus;
import com.business.api.entity.enumtype.RequestType;
import com.business.api.entity.enumtype.StatusType;
import com.business.api.exceptions.*;
import com.business.api.vo.PlaceOrderRequest;
import com.business.dubbo.charge.cache.BusinessTypeLocalCache;
import com.business.dubbo.charge.dao.AccountFundFlowMapper;
import com.business.dubbo.charge.dao.RechargeOrderMapper;
import com.business.dubbo.charge.dao.RequestLogMapper;
import com.business.dubbo.charge.utils.IDGenerator;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by chenll on 2017/6/24.
 * 下单业务
 */
@Component
public class PlaceOrderService {

    private static Logger logger = LoggerFactory.getLogger(PlaceOrderService.class);

    @Autowired
    private RequestLogMapper requestLogMapper;

    @Autowired
    private MerchantInfoService merchantInfoService;

    @Autowired
    private MerchantApplyBusinessService merchantApplyBusinessService;

    @Autowired
    private QcoinBlackListService qcoinBlackListService;

    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;

    @Autowired
    private MerchantAccountInfoService merchantAccountInfoService;

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;

    @Autowired
    private RechargeOrderService rechargeOrderServiceImpl;

    @Autowired
    private BusinessTypeLocalCache businessTypeLocalCache;

    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    private QcoinRebateConfigService qcoinRebateConfigServiceImp;


    private final static int NOTIFYNUM=5;


    private final static List<Integer> BUSINESSTYPES = Arrays.asList(10,11,12,13);


    public void saveLog(RequestType requestType, String data){
        RequestLog requestLog = new RequestLog();
        requestLog.setData(data);
        requestLog.setCreateBy("Unkown");
        requestLog.setCreateTime(new Date());
        requestLog.setType(RequestType.PLACEORDER);
        requestLogMapper.insert(requestLog);
    }

    @Transactional
    public RechargeOrder processOrder(PlaceOrderRequest placeOrderRequest){
        MerchantInfo merchantAccount = merchantInfoService.findByAccount(placeOrderRequest.getMerchantAccount());
        if (merchantAccount==null){
            throw new MerchantNotExistException();
        }
        //验证账户是否冻结
        Byte status = merchantAccount.getFrozenStatus();
        if (AccountStatus.FROZEN.getValue().byteValue()==status.byteValue()){
            throw new AccountFrozenException();
        }

        MerchantApplyBusiness merchantApplyBusiness = merchantApplyBusinessService.findBy(placeOrderRequest.getMerchantAccount(),placeOrderRequest.getBusinessType());
        if (merchantApplyBusiness == null){
            throw new AccountNoBusinessException();
        }
        if (AccountStatus.FROZEN.getValue().byteValue() == merchantApplyBusiness.getState().byteValue()){
            throw new AccountNoBusinessException();
        }
        //验证业务类型是否存在
        if (!BUSINESSTYPES.contains(placeOrderRequest.getBusinessType())){
            throw new BusinessTypeNotExistException();
        }

        //验证 placeOrderRequest.getMerchantOrderNo()在表中是否存在重复的
        int OrderNoNum = rechargeOrderServiceImpl.verifyMercantOrderNo(placeOrderRequest.getMerchantAccount(),placeOrderRequest.getMerchantOrderNo());
        if (OrderNoNum > 0){
            throw new DuplicateMerchantOrderNOException();
        }
        //面额和数量对数字验证
        if (!NumberUtils.isNumber(String.valueOf(placeOrderRequest.getCharegeUnitValue()))){
            throw new ParamNotNumberException();
        }
        if (!NumberUtils.isNumber(String.valueOf(placeOrderRequest.getChargeNumber()))){
            throw new ParamNotNumberException();
        }

        QcoinBlackList qqBlack = qcoinBlackListService.findByNumber(placeOrderRequest.getChargeAccount());
        if (qqBlack!=null && qqBlack.getState().byteValue()== StatusType.NORMAL.getValue()){
            throw new QQInBlackListException();
        }

        //生成接单表
        RechargeOrder rechargeOrder = generatorRechargeOrder(placeOrderRequest);

        MerchantAccountInfo merchantAccountInfo = merchantAccountInfoService.findByAccount(placeOrderRequest.getMerchantAccount());
        if (merchantAccountInfo==null){
            throw new MerchantNotExistException();
        }
        if (merchantAccountInfo.getBalance() < rechargeOrder.getDiscountAmount()){
            throw new MerchantNoMoneyException();
        }
        merchantAccountInfoService.updateBalance(placeOrderRequest.getMerchantAccount(),-rechargeOrder.getDiscountAmount());
        rechargeOrder.setPayState(13);
        rechargeOrder.setPayTime(new Date());
        rechargeOrderMapper.insert(rechargeOrder);

        this.addAcountFundFlow(placeOrderRequest,rechargeOrder,merchantAccountInfo,rechargeOrder.getDiscountAmount());

        logger.info("商户:{} 接单成功,orderNo:{}",placeOrderRequest.getMerchantAccount(),rechargeOrder.getOrderNo());
        return rechargeOrder;
    }

    private void addAcountFundFlow(PlaceOrderRequest placeOrderRequest,RechargeOrder rechargeOrder,MerchantAccountInfo merchantAccountInfo,Long amount){
        AccountFundFlow accountFundFlow = new AccountFundFlow();
        accountFundFlow.setMerchantAccount(placeOrderRequest.getMerchantAccount());
        accountFundFlow.setAccountType(0);
        accountFundFlow.setChangeAmount(-amount);
        accountFundFlow.setAmountBeforeChange(merchantAccountInfo.getBalance());
        accountFundFlow.setChangeAmount(amount);
        accountFundFlow.setAmountAfterChange(merchantAccountInfo.getBalance()-amount);
        accountFundFlow.setChangeTime(new Date());
        accountFundFlow.setChangeReason("充值减款");
        accountFundFlow.setChangeType(2);
        accountFundFlow.setOrderNo(rechargeOrder.getOrderNo());
        accountFundFlow.setMerchantOrderNo(placeOrderRequest.getMerchantOrderNo());
        accountFundFlow.setCreateTime(new Date());
        accountFundFlow.setUpdateTime(new Date());
        accountFundFlow.setCreateBy("unkown");
        accountFundFlow.setUpdateBy("unkown");
        accountFundFlowMapper.insert(accountFundFlow);
    }

    private RechargeOrder generatorRechargeOrder(PlaceOrderRequest placeOrderRequest){
        RechargeOrder rechargeOrder = new RechargeOrder();
        rechargeOrder.setOrderNo(IDGenerator.getInstance().getID());
        rechargeOrder.setBusinessType(placeOrderRequest.getBusinessType());
        rechargeOrder.setMerchantOrderNo(placeOrderRequest.getMerchantOrderNo());
        rechargeOrder.setMerchantAccount(placeOrderRequest.getMerchantAccount());
        rechargeOrder.setExtendAccount(placeOrderRequest.getExpandAccount());
        rechargeOrder.setRechargeAccount(placeOrderRequest.getChargeAccount());
        rechargeOrder.setRechargeValue(placeOrderRequest.getCharegeUnitValue());
        rechargeOrder.setRechargeNum(placeOrderRequest.getChargeNumber());
        rechargeOrder.setMerchantOrderTime(placeOrderRequest.getMerchantRequestTime());
        rechargeOrder.setOrderTime(new Date());

        rechargeOrder.setOrderAmount(placeOrderRequest.getCharegeUnitValue()*placeOrderRequest.getChargeNumber()*1000);
        rechargeOrder.setPayAmount(placeOrderRequest.getCharegeUnitValue()*placeOrderRequest.getChargeNumber()*1000);

        //根据customeip去查ip对应的省份，再根据省份和商户号查qcoin_rebate_config
        IpAddress ipAddress = ipAddressService.findBy(placeOrderRequest.getCustomerIp());
        QcoinRebateConfig qcoinRebateConfig = null;
        if (ipAddress == null){//取不到ip的身份默认用四川
            qcoinRebateConfig = qcoinRebateConfigServiceImp.findBy(placeOrderRequest.getMerchantAccount(), "028");
        }else{
            qcoinRebateConfig = qcoinRebateConfigServiceImp.findBy(placeOrderRequest.getMerchantAccount(), ipAddress.getProvinceCode());
        }
        Double discountRate = qcoinRebateConfig.getDiscountRate();
        BigDecimal result = new BigDecimal(placeOrderRequest.getCharegeUnitValue()).
                multiply(new BigDecimal(placeOrderRequest.getChargeNumber())) .
                multiply(new BigDecimal(discountRate,new MathContext(3, RoundingMode.HALF_UP))) ;
        result = result.multiply(new BigDecimal(1000));
        rechargeOrder.setDiscountAmount(result.longValue());

        rechargeOrder.setSuccessAmount(0L);
        rechargeOrder.setExtendParam(placeOrderRequest.getExpandParam());
        rechargeOrder.setBusinessAttach("");
        rechargeOrder.setOrderDetail(getDesc(placeOrderRequest.getBusinessType(),placeOrderRequest.getCharegeUnitValue(),placeOrderRequest.getChargeNumber()));//组装中文描述
         rechargeOrder.setPayState(0);
//        rechargeOrder.setPayTime();
        rechargeOrder.setOrderState(0);
        rechargeOrder.setRefundAmount(0L);
        rechargeOrder.setRefundState(0);
        rechargeOrder.setAttach(placeOrderRequest.getAttach());
        rechargeOrder.setSrcPlatform("未知");
        rechargeOrder.setRebateType(0);
        rechargeOrder.setCustomerIp(placeOrderRequest.getCustomerIp());

        rechargeOrder.setNotifyUrl(placeOrderRequest.getNotifyUrl());
        rechargeOrder.setNotifyTimes(NOTIFYNUM);
        rechargeOrder.setNotifyInterval("30");
        rechargeOrder.setNotifyState(0);//未通知
        rechargeOrder.setDiscountProvinceCode(qcoinRebateConfig.getProvinceCode());//根据上面查询所得
        rechargeOrder.setDiscountRate(qcoinRebateConfig.getDiscountRate());//根据上面查询所得
        return rechargeOrder;
    }


    private String getDesc(Integer businessType,Long charegeUnitValue,Long chargeNum){
        try {
            DictionaryBusinessInfo info = businessTypeLocalCache.getBusinessType(businessType);
            return info.getName()+"充值"+charegeUnitValue*chargeNum+"元";
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }

}
