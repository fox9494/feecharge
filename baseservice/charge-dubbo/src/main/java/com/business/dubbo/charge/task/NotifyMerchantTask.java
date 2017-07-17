package com.business.dubbo.charge.task;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.entity.RechargeOrder;
import com.business.api.entity.enumtype.BusinessType;
import com.business.api.entity.enumtype.OrderStatus;
import com.business.api.entity.enumtype.StatusType;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.api.vo.ChannelQueryOrderRequest;
import com.business.api.vo.NotifyMerchantVO;
import com.business.dubbo.charge.channel.ChannelAdaptor;
import com.business.dubbo.charge.channel.ChannelBusinessService;
import com.business.dubbo.charge.notify.NotifyMerchantService;
import com.business.dubbo.charge.service.QcoinChannelOrderService;
import com.business.dubbo.charge.service.RechargeOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by chenll on 2017/7/15.
 * 通知下游的任务
 */
public class NotifyMerchantTask implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(NotifyMerchantTask.class);

    private static final int SUCESS=1;

    private static final int FAIL=2;


    private RechargeOrderService rechargeOrderService;

    //查询间隔时间
    private Long retryInterval;


    //上次查单时间
    private Long lastTime;


    private String  orderNo;

    private int notifyNum;

    public NotifyMerchantTask(RechargeOrderService rechargeOrderService,String orderNo){
        this.rechargeOrderService = rechargeOrderService;
        this.orderNo = orderNo;
    }


    public void run()  {
        RechargeOrder rechargeOrder = rechargeOrderService.findByOrderNo(orderNo);
        retryInterval = Long.parseLong(rechargeOrder.getNotifyInterval())*1000;
        notifyNum = rechargeOrder.getNotifyTimes();
        int count=0;
        Long firstTime = System.currentTimeMillis();
        String result="";
        while(count < notifyNum){
            long now = System.currentTimeMillis();
            if (count==0){//第一次通知
                //调用通知下游
                firstTime =  System.currentTimeMillis();
                lastTime = firstTime;
                result = NotifyMerchantService.notifyMerchant(rechargeOrder.getNotifyUrl(),this.generateNotifyRequest(rechargeOrder));
                count ++;
            }

            if (now - lastTime >= retryInterval){
                //调用通知下游
                lastTime = now;
                result = NotifyMerchantService.notifyMerchant(rechargeOrder.getNotifyUrl(),this.generateNotifyRequest(rechargeOrder));
                count++;
            }
        }
        rechargeOrder.setNotifyFirstTime(new Date(firstTime));
        rechargeOrder.setNotifyLatestTime(new Date(lastTime));
        rechargeOrder.setNotifyState(result.equals("success")? SUCESS:FAIL);

    }

    private NotifyMerchantVO generateNotifyRequest(RechargeOrder rechargeOrder){
        NotifyMerchantVO vo = new NotifyMerchantVO();
        vo.setBusinessType(rechargeOrder.getBusinessType());
        vo.setMerchantAccount(rechargeOrder.getMerchantAccount());
        vo.setMerchantOrderNo(rechargeOrder.getMerchantOrderNo());
        vo.setMerchantRequestTime(rechargeOrder.getMerchantOrderTime());
        vo.setOrderNo(rechargeOrder.getOrderNo());
        vo.setOrderTime(rechargeOrder.getOrderTime());
        vo.setOrderAmount(rechargeOrder.getOrderAmount());
        vo.setPayAmount(rechargeOrder.getPayAmount());
        vo.setDiscountAmount(rechargeOrder.getDiscountAmount());
        vo.setSuccessAmount(rechargeOrder.getSuccessAmount());
        vo.setOrderState(rechargeOrder.getOrderState());
        vo.setAttach(rechargeOrder.getAttach());
        vo.setSign("");//TODO
        return vo;
    }

}
