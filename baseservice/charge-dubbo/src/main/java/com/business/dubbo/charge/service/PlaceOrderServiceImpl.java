package com.business.dubbo.charge.service;

import com.business.api.entity.*;
import com.business.api.entity.enumtype.AccountStatus;
import com.business.api.entity.enumtype.RequestType;
import com.business.api.exceptions.AccountFrozenException;
import com.business.api.exceptions.AccountNoBusinessException;
import com.business.api.exceptions.MerchantNoMoneyException;
import com.business.api.exceptions.MerchantNotExistException;
import com.business.api.vo.PlaceOrderRequest;
import com.business.dubbo.charge.dao.AccountFundFlowMapper;
import com.business.dubbo.charge.dao.RechargeOrderMapper;
import com.business.dubbo.charge.dao.RequestLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by chenll on 2017/6/24.
 * 下单业务
 */
@Component
public class PlaceOrderServiceImpl{

    private static Logger logger = LoggerFactory.getLogger(PlaceOrderServiceImpl.class);

    @Autowired
    private RequestLogMapper requestLogMapper;

    @Autowired
    private MerchantInfoServiceImpl merchantInfoService;

    @Autowired
    private MerchantApplyBusinessServiceImpl merchantApplyBusinessService;

    @Autowired
    private QcoinBlackListServiceImpl qcoinBlackListService;

    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;

    @Autowired
    private MerchantAccountInfoServiceImpl merchantAccountInfoService;

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;


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

        QcoinBlackList qqBlack = qcoinBlackListService.findByNumber(placeOrderRequest.getChargeAccount());

        //生成接单表
        RechargeOrder rechargeOrder = generatorRechargeOrder(placeOrderRequest);
        rechargeOrderMapper.insert(rechargeOrder);
        MerchantAccountInfo merchantAccountInfo = merchantAccountInfoService.findByAccount(placeOrderRequest.getMerchantAccount());
        if (merchantAccountInfo==null){
            throw new MerchantNotExistException();
        }
        if (merchantAccountInfo.getBalance()<=0){
            throw new MerchantNoMoneyException();
        }
        //TODO 金额计算没有打折
        Long amount = placeOrderRequest.getCharegeUnitValue()*placeOrderRequest.getChargeNumber();
        merchantAccountInfoService.updateBalance(placeOrderRequest.getMerchantAccount(),-amount);
        this.addAcountFundFlow(placeOrderRequest,rechargeOrder,merchantAccountInfo,amount);

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
        rechargeOrder.setOrderNo(UUID.randomUUID().toString());//暂时用uuid
        rechargeOrder.setBusinessType(placeOrderRequest.getBusinessType());
        rechargeOrder.setMerchantOrderNo(placeOrderRequest.getMerchantOrderNo());
        rechargeOrder.setMerchantAccount(placeOrderRequest.getMerchantAccount());
        rechargeOrder.setExtendAccount(placeOrderRequest.getExpandAccount());
        rechargeOrder.setRechargeAccount(placeOrderRequest.getChargeAccount());
        rechargeOrder.setRechargeValue(placeOrderRequest.getCharegeUnitValue());
        rechargeOrder.setRechargeNum(placeOrderRequest.getChargeNumber());
        rechargeOrder.setMerchantOrderTime(placeOrderRequest.getMerchantRequestTime());
        rechargeOrder.setOrderTime(new Date());
        //TODO 暂时这样计算
        rechargeOrder.setOrderAmount(placeOrderRequest.getCharegeUnitValue()*placeOrderRequest.getChargeNumber());
        rechargeOrder.setPayAmount(0L);
        rechargeOrder.setDiscountAmount(0L);
        rechargeOrder.setSuccessAmount(0L);
        rechargeOrder.setExtendParam(placeOrderRequest.getExpandParam());
        rechargeOrder.setBusinessAttach("");
        rechargeOrder.setOrderDetail("");
//         rechargeOrder.setPayState();
//        rechargeOrder.setPayTime();
        rechargeOrder.setOrderState(0);
        rechargeOrder.setRefundAmount(0L);
        rechargeOrder.setRefundState(0);

        rechargeOrder.setRebateType(0);
        rechargeOrder.setRebateAmount(0L);
        rechargeOrder.setRebateState(Byte.valueOf("0"));
        rechargeOrder.setRebateTime(new Date());
        rechargeOrder.setCustomerIp(placeOrderRequest.getCustomerIp());
        rechargeOrder.setMerchantIp("18.22.33.44");
        rechargeOrder.setNotifyUrl(placeOrderRequest.getNotifyUrl());
        rechargeOrder.setNotifyTimes(0);
        rechargeOrder.setNotifyInterval("30");
        rechargeOrder.setAttach(placeOrderRequest.getAttach());
        rechargeOrder.setSrcPlatform("未知");
//        rechargeOrder.
        return rechargeOrder;
    }
}
