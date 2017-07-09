package com.business.dubbo.charge.service;

import com.business.api.entity.*;
import com.business.api.entity.enumtype.BusinessType;
import com.business.api.entity.enumtype.OrderStatus;
import com.business.api.entity.enumtype.StatusType;
import com.business.dubbo.charge.dao.QcoinChannelOrderMapper;
import com.business.dubbo.charge.dao.QcoinOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by chenll on 2017/7/9.
 */
public class DispatcherServiceImpl {

    @Autowired
    private QcoinOrderMapper qcoinOrderMapper;

    @Autowired
    private QcoinChannelService qcoinChannelService;

    @Autowired
    private PartnerChannelService partnerChannelService;

    @Autowired
    private PartnerChannelDiscountConfigService partnerChannelDiscountConfigService;

    @Autowired
    private QcoinChannelOrderMapper qcoinChannelOrderMapper;

    public void dispathcer(RechargeOrder rechargeOrder){

        //Q币业务
     if  (BusinessType.QICON.getValue().intValue()==rechargeOrder.getBusinessType()){
         qcoinOrderMapper.insert(this.generateQcoinOrder(rechargeOrder));
         List<QcoinMerchantUsableChannel> list = qcoinChannelService.findBy(rechargeOrder.getMerchantAccount(), null);
         if (!list.isEmpty()){
             for (QcoinMerchantUsableChannel qcoinMerchantUsableChannel:list) {
                 if (qcoinMerchantUsableChannel.getState().intValue()== StatusType.INVALID.getValue().intValue()){
                     continue;
                 }
                 PartnerChannel partnerChannel = partnerChannelService.findByChannel(qcoinMerchantUsableChannel.getChannelId());
                 if (StatusType.INVALID.getValue().intValue()==partnerChannel.getState().intValue()){
                     continue;
                 }
                 //插入q渠道表
                 qcoinChannelOrderMapper.insert(this.generateQcoinChannelOrder(rechargeOrder,qcoinMerchantUsableChannel));

                 //开始调用渠道，注意判断同步调用还是异步调用


             }
         }
     }

    }

    private QcoinChannelOrder generateQcoinChannelOrder(RechargeOrder rechargeOrder,QcoinMerchantUsableChannel qcoinMerchantUsableChannel){
        QcoinChannelOrder qcoinChannelOrder = new QcoinChannelOrder();
        qcoinChannelOrder.setChannelOrderNo(UUID.randomUUID().toString());
        qcoinChannelOrder.setOrderNo(rechargeOrder.getOrderNo());
        qcoinChannelOrder.setMerAccount(rechargeOrder.getMerchantAccount());
        qcoinChannelOrder.setMerOrderNo(rechargeOrder.getMerchantOrderNo());
        qcoinChannelOrder.setChannelId(qcoinMerchantUsableChannel.getChannelId());
        qcoinChannelOrder.setPartnerOrderNo("");//TODO
        qcoinChannelOrder.setCreateTime(new Date());
        qcoinChannelOrder.setRechargeAmount(rechargeOrder.getOrderAmount());//TODO
        qcoinChannelOrder.setSuccessAmount(0L);//TODO
        qcoinChannelOrder.setProvinceCode(rechargeOrder.getDiscountProvinceCode());
        qcoinChannelOrder.setQq(rechargeOrder.getRechargeAccount());//TODO
        qcoinChannelOrder.setOrderState(0);//TODO
        qcoinChannelOrder.setHandleTime(new Date());
        qcoinChannelOrder.setEndTime(null);//TODO
        qcoinChannelOrder.setChannelResult("");//TODO
        qcoinChannelOrder.setChannelState("");//TODO
        qcoinChannelOrder.setNotifyState(0);
        qcoinChannelOrder.setIp(rechargeOrder.getCustomerIp());
        qcoinChannelOrder.setAllowDelay(1);
        qcoinChannelOrder.setFixedIp("");//TODO
        //TODO
//        qcoinChannelOrder.setDiscountRate(partnerChannelDiscountConfigService.);




        return qcoinChannelOrder;
    }

    private QcoinOrder generateQcoinOrder(RechargeOrder rechargeOrder){
        QcoinOrder qcionOrder = new QcoinOrder();
        qcionOrder.setOrderNo(UUID.randomUUID().toString());
        qcionOrder.setMerOrderNo(rechargeOrder.getMerchantOrderNo());
        qcionOrder.setMerAccount(rechargeOrder.getMerchantAccount());
        qcionOrder.setRechargeAccount(rechargeOrder.getRechargeAccount());
        qcionOrder.setRechargeValue(rechargeOrder.getRechargeValue());
        qcionOrder.setRechargeNum(rechargeOrder.getRechargeNum());
        qcionOrder.setOrderAmount(rechargeOrder.getOrderAmount());
        qcionOrder.setPayAmount(rechargeOrder.getPayAmount());
        qcionOrder.setDiscountAmount(rechargeOrder.getDiscountAmount());
        qcionOrder.setSuccessAmount(rechargeOrder.getSuccessAmount());
        qcionOrder.setOrderDetail(rechargeOrder.getOrderDetail());
        qcionOrder.setOrderState(OrderStatus.READY.getValue());
        qcionOrder.setOrderTime(new Date());
        qcionOrder.setProvinceCode(rechargeOrder.getDiscountProvinceCode());
        qcionOrder.setCustomerIp(rechargeOrder.getCustomerIp());
        qcionOrder.setHandleState(0);//TODO
        qcionOrder.setHandleTime(null);//TODO
        qcionOrder.setChannelResult("");
        qcionOrder.setAllowSplit(0);
        qcionOrder.setAllowDelay(1);
        qcionOrder.setMatchState(0);
        qcionOrder.setMatchProvinceCode(null);
        qcionOrder.setDiscountRate(rechargeOrder.getDiscountRate());
        qcionOrder.setDiscountProvinceCode(null);
        return qcionOrder;
    }
}
