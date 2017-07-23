package com.business.recharge.service;

import com.business.recharge.cache.BusinessTypeLocalCache;
import com.business.recharge.dao.AccountFundFlowMapper;
import com.business.recharge.dao.RechargeOrderMapper;
import com.business.recharge.entity.*;
import com.business.recharge.exceptions.*;
import com.business.recharge.utils.IDGenerator;
import com.business.recharge.vo.PlaceOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by chenll on 2017/6/24.
 * 下单业务
 */
@Component
public class PlaceOrderService {

    private static Logger logger = LoggerFactory.getLogger(PlaceOrderService.class);

    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;

    @Autowired
    private MerchantAccountInfoService merchantAccountInfoService;

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;

    @Autowired
    private BusinessTypeLocalCache businessTypeLocalCache;

    @Autowired
    private IpAddressService ipAddressService;

    @Autowired
    private QcoinRebateConfigService qcoinRebateConfigService;

    @Autowired
    private DispatcherService dispatcherService;

    @Autowired
    private AccountFundFlowService accountFundFlowService;


    private final static int NOTIFYNUM=5;


    @Transactional
    public RechargeOrder processOrder(PlaceOrderRequest placeOrderRequest){
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

        accountFundFlowService.addAcountFundFlow(rechargeOrder,merchantAccountInfo,-rechargeOrder.getDiscountAmount());

        logger.info("商户:{} 接单成功,orderNo:{}",placeOrderRequest.getMerchantAccount(),rechargeOrder.getOrderNo());

        //异步调用
        dispatcherService.dispathcer(rechargeOrder);
        return rechargeOrder;
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
            qcoinRebateConfig = qcoinRebateConfigService.findBy(placeOrderRequest.getMerchantAccount(), "028");
        }else{
            qcoinRebateConfig = qcoinRebateConfigService.findBy(placeOrderRequest.getMerchantAccount(), ipAddress.getProvinceCode());
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
