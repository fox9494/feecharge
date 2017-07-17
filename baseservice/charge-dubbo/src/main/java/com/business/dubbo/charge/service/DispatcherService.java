package com.business.dubbo.charge.service;

import com.business.api.entity.*;
import com.business.api.entity.enumtype.BusinessType;
import com.business.api.entity.enumtype.OrderStatus;
import com.business.api.entity.enumtype.StatusType;
import com.business.api.vo.ChannelPlaceOrderRequest;
import com.business.api.vo.ChannelPlaceOrderResponse;
import com.business.api.vo.PlaceOrderVO;
import com.business.dubbo.charge.channel.ChannelAdaptor;
import com.business.dubbo.charge.channel.ChannelBusinessService;
import com.business.dubbo.charge.dao.QcoinChannelOrderMapper;
import com.business.dubbo.charge.dao.QcoinOrderMapper;
import com.business.dubbo.charge.task.ChannelQueryOrderTask;
import com.business.dubbo.charge.task.QcoinChannelOrderResultTask;
import com.business.dubbo.charge.utils.IDGenerator;
import com.business.dubbo.charge.utils.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by chenll on 2017/7/9.
 */
public class DispatcherService {

    @Autowired
    private QcoinOrderMapper qcoinOrderMapper;

    @Autowired
    private QcoinChannelService qcoinChannelService;

    @Autowired
    private PartnerChannelService partnerChannelService;

    @Autowired
    private QcoinChannelOrderMapper qcoinChannelOrderMapper;

    @Autowired
    private QcoinChannelOrderService qcoinChannelOrderService;

    public void dispathcer(RechargeOrder rechargeOrder){

        //Q币业务
     if  (BusinessType.QICON.getValue().intValue()==rechargeOrder.getBusinessType()){
         qcoinOrderMapper.insert(this.generateQcoinOrder(rechargeOrder));

         List<QcoinMerchantUsableChannel> list = qcoinChannelService.findBy(rechargeOrder.getMerchantAccount(), null,StatusType.NORMAL.getValue());
         if (!list.isEmpty()){
             for (QcoinMerchantUsableChannel qcoinMerchantUsableChannel:list) {
                 PartnerChannel partnerChannel = partnerChannelService.findByChannel(qcoinMerchantUsableChannel.getChannelId());
                 if (StatusType.INVALID.getValue().intValue()==partnerChannel.getState().intValue()){
                     continue;
                 }
                 //插入q渠道表
                 QcoinChannelOrder qcoinChannelOrder = this.generateQcoinChannelOrder(rechargeOrder, qcoinMerchantUsableChannel);
                 qcoinChannelOrderMapper.insert(qcoinChannelOrder);

                 ChannelBusinessService channelBusinessService = ChannelAdaptor.getChannel(qcoinMerchantUsableChannel.getChannelId());
                 ChannelPlaceOrderRequest request = new ChannelPlaceOrderRequest();
                 request.setSign("");
                 PlaceOrderVO placeOrderVO = new PlaceOrderVO();
                 placeOrderVO.setBusinessType(rechargeOrder.getBusinessType());
                 //....
                 request.setPlaceOrderVO(placeOrderVO);
                 Long firstCheckTime = System.currentTimeMillis();
                 ChannelPlaceOrderResponse response = channelBusinessService.requestChannelPlaceOrder(request);

                 if (OrderStatus.SUCCESS.getValue()==response.getOrderVO().getOrderStatus()){//调用渠道成功

                     break;//成功终止调下一渠道
                 }
                 if (OrderStatus.FAIL.getValue() == response.getOrderVO().getOrderStatus()){

                 }
                 if (OrderStatus.PROCESSING.getValue()==response.getOrderVO().getOrderStatus()){//充值中，启动定时任务查单或等待回调


                     //启动线程查单
                     ThreadPoolManager.getInstance().submit(new ChannelQueryOrderTask(qcoinChannelOrderService, firstCheckTime, rechargeOrder.getMerchantAccount(),
                             qcoinChannelOrder.getChannelOrderNo(), qcoinMerchantUsableChannel.getChannelId()));

                     Future<QcoinChannelOrder> result = ThreadPoolManager.getInstance().submit(new QcoinChannelOrderResultTask(qcoinChannelOrderService,
                             rechargeOrder.getMerchantAccount(),qcoinChannelOrder.getChannelOrderNo()));

                     try {
                         QcoinChannelOrder orderResult = result.get();
                         if (OrderStatus.SUCCESS.getValue()==orderResult.getOrderState()){//调用渠道成功

                             break;//成功终止调下一渠道
                         }
                         if (OrderStatus.FAIL.getValue() == orderResult.getOrderState()){

                         }
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     } catch (ExecutionException e) {
                         e.printStackTrace();
                     }


                 }

             }

             //所有渠道都走完了，查询一次状态，主要处理失败
         }else{//没有渠道可用当失败处理
            //主订单修改状态
             //接单表修改状态
             //退回扣款
             //回调下游
         }
     }

    }

    private void sucessOnChannel(ChannelPlaceOrderResponse response){
//        qcoinChannelOrderService.updatePartnerOrderNo();

        //主订单修改状态
        //接单表修改状态
        //回调商户提供的url
    }

    private void faileOnChannel(ChannelPlaceOrderResponse response){
        //获取下一渠道
    }

    private QcoinChannelOrder generateQcoinChannelOrder(RechargeOrder rechargeOrder, QcoinMerchantUsableChannel qcoinMerchantUsableChannel){
        QcoinChannelOrder qcoinChannelOrder = new QcoinChannelOrder();
        qcoinChannelOrder.setChannelOrderNo(IDGenerator.getInstance().getID());
        qcoinChannelOrder.setOrderNo(rechargeOrder.getOrderNo());
        qcoinChannelOrder.setMerchantAccount(rechargeOrder.getMerchantAccount());
        qcoinChannelOrder.setMerOrderNo(rechargeOrder.getMerchantOrderNo());
        qcoinChannelOrder.setChannelId(qcoinMerchantUsableChannel.getChannelId());
        qcoinChannelOrder.setPartnerOrderNo("");//TODO 等待回写
        qcoinChannelOrder.setCreateTime(new Date());
        qcoinChannelOrder.setRechargeAmount(rechargeOrder.getOrderAmount());
        qcoinChannelOrder.setSuccessAmount(0L);
        qcoinChannelOrder.setProvinceCode(rechargeOrder.getDiscountProvinceCode());
        qcoinChannelOrder.setQq(rechargeOrder.getRechargeAccount());
        qcoinChannelOrder.setOrderState(20);
        qcoinChannelOrder.setHandleTime(new Date());
        qcoinChannelOrder.setEndTime(null);//TODO
        qcoinChannelOrder.setChannelResult("");//TODO
        qcoinChannelOrder.setChannelState("");//TODO
        qcoinChannelOrder.setNotifyState(0);
        qcoinChannelOrder.setIp(rechargeOrder.getCustomerIp());
        qcoinChannelOrder.setAllowDelay(1);
        qcoinChannelOrder.setFixedIp(null);
        qcoinChannelOrder.setDiscountRate(1.0);
        return qcoinChannelOrder;
    }

    private QcoinOrder generateQcoinOrder(RechargeOrder rechargeOrder){
        QcoinOrder qcionOrder = new QcoinOrder();
        qcionOrder.setOrderNo(IDGenerator.getInstance().getID());
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
        qcionOrder.setAllowSplit(0);
        qcionOrder.setAllowDelay(0);
        qcionOrder.setMatchState(0);
        qcionOrder.setMatchProvinceCode(null);
        qcionOrder.setDiscountRate(rechargeOrder.getDiscountRate());
        qcionOrder.setDiscountProvinceCode(rechargeOrder.getDiscountProvinceCode());
        return qcionOrder;
    }
}
