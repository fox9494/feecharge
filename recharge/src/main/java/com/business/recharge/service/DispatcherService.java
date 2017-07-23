package com.business.recharge.service;

import com.business.recharge.channel.ChannelAdaptor;
import com.business.recharge.channel.ChannelBusinessService;
import com.business.recharge.dao.QcoinChannelOrderMapper;
import com.business.recharge.dao.QcoinOrderMapper;
import com.business.recharge.entity.*;
import com.business.recharge.entity.enumtype.BusinessType;
import com.business.recharge.entity.enumtype.OrderStatus;
import com.business.recharge.entity.enumtype.StatusType;
import com.business.recharge.task.ChannelQueryOrderTask;
import com.business.recharge.task.NotifyMerchantTask;
import com.business.recharge.task.QcoinChannelOrderResultTask;
import com.business.recharge.utils.IDGenerator;
import com.business.recharge.utils.ThreadPoolManager;
import com.business.recharge.vo.ChannelPlaceOrderRequest;
import com.business.recharge.vo.ChannelPlaceOrderResponse;
import com.business.recharge.vo.PlaceOrderRequest;
import com.business.recharge.vo.PlaceOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by chenll on 2017/7/9.
 */
@Service
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

    @Autowired
    private QcoinOrderService qcoinOrderService;

    @Autowired
    private RechargeOrderService rechargeOrderService;

    @Autowired
    private MerchantAccountInfoService merchantAccountInfoService;

    @Autowired
    private  AccountFundFlowService accountFundFlowService;

    @Async
    @Transactional
    public void dispathcer(RechargeOrder rechargeOrder){
        //Q币业务
     if  (BusinessType.QICON.getValue().intValue()==rechargeOrder.getBusinessType()){
         QcoinOrder qcoinOrder = this.generateQcoinOrder(rechargeOrder);
         qcoinOrderMapper.insert(qcoinOrder);

         List<QcoinMerchantUsableChannel> list = qcoinChannelService.findBy(rechargeOrder.getMerchantAccount(), null, StatusType.NORMAL.getValue());
         if (!list.isEmpty()){
             QcoinChannelOrder qcoinChannelOrder=null;
             qcoinOrderService.updateStatus(qcoinOrder.getOrderNo(), OrderStatus.PROCESSING.getValue());
             for (QcoinMerchantUsableChannel qcoinMerchantUsableChannel:list) {
                 PartnerChannel partnerChannel = partnerChannelService.findByChannel(qcoinMerchantUsableChannel.getChannelId());
                 if (StatusType.INVALID.getValue().intValue()==partnerChannel.getState().intValue()){
                     continue;
                 }
                 //插入q渠道表
                 qcoinChannelOrder = this.generateQcoinChannelOrder(rechargeOrder, qcoinMerchantUsableChannel);
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

                 if (OrderStatus.SUCCESS.getValue()==response.getOrderVO().getOrderStatus()){
                     this.responseSyncSucessOnChannel(qcoinChannelOrder,response);
                     break;//调用渠道成功终止不调用下一渠道
                 }
                 if (OrderStatus.FAIL.getValue() == response.getOrderVO().getOrderStatus()){
                     this.responseSyncFailOnChannel(qcoinChannelOrder,response);
                 }
                 if (OrderStatus.PROCESSING.getValue()==response.getOrderVO().getOrderStatus()){//充值中，启动定时任务查单或等待回调
                     //启动线程查单
                     ThreadPoolManager.getInstance().submit(new ChannelQueryOrderTask(qcoinChannelOrderService, firstCheckTime, rechargeOrder.getMerchantAccount(),
                             qcoinChannelOrder.getChannelOrderNo(), qcoinMerchantUsableChannel.getChannelId()));

                     //启动线程查询异步结果，基于回调和查单的结果
                     Future<QcoinChannelOrder> result = ThreadPoolManager.getInstance().submit(new QcoinChannelOrderResultTask(qcoinChannelOrderService,
                             rechargeOrder.getMerchantAccount(),qcoinChannelOrder.getChannelOrderNo()));
                     try {
                         QcoinChannelOrder orderResult = result.get();
                         if (OrderStatus.SUCCESS.getValue()==orderResult.getOrderState()){//调用渠道成功
                             this.responseAsyncSucessOnChannel(orderResult);
                             break;//成功终止调下一渠道
                         }
                         if (OrderStatus.FAIL.getValue() == orderResult.getOrderState()){
                             this.responseAsyncFailOnChannel(orderResult);
                         }
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     } catch (ExecutionException e) {
                         e.printStackTrace();
                     }
                 }
             }

             //所有渠道都走完了，查询一次状态，主要处理失败
             QcoinChannelOrder entity = qcoinChannelOrderService.findByAccountAndOrderNo(rechargeOrder.getMerchantAccount(), qcoinChannelOrder.getChannelOrderNo());
             if (entity.getOrderState() == OrderStatus.FAIL.getValue()){
                 ThreadPoolManager.getInstance().execute(new NotifyMerchantTask(rechargeOrderService,qcoinChannelOrder.getOrderNo()));
                 //加款
                 MerchantAccountInfo merchantAccountInfo = merchantAccountInfoService.findByAccount(rechargeOrder.getMerchantAccount());
                 merchantAccountInfoService.updateBalance(rechargeOrder.getMerchantAccount(),rechargeOrder.getDiscountAmount());
                 accountFundFlowService.addAcountFundFlow(rechargeOrder,merchantAccountInfo,rechargeOrder.getDiscountAmount());
             }

         }else{//没有渠道可用当失败处理

             qcoinOrderService.updateStatus(qcoinOrder.getOrderNo(),OrderStatus.FAIL.getValue());
             rechargeOrderService.updateStatus(qcoinOrder.getOrderNo(),OrderStatus.FAIL.getValue());
             ThreadPoolManager.getInstance().execute(new NotifyMerchantTask(rechargeOrderService,rechargeOrder.getOrderNo()));
             //加款
             MerchantAccountInfo merchantAccountInfo = merchantAccountInfoService.findByAccount(rechargeOrder.getMerchantAccount());
             merchantAccountInfoService.updateBalance(rechargeOrder.getMerchantAccount(),rechargeOrder.getDiscountAmount());
             accountFundFlowService.addAcountFundFlow(rechargeOrder,merchantAccountInfo,rechargeOrder.getDiscountAmount());

         }
     }

    }

    //处理同步的结果
    private void responseSyncSucessOnChannel(QcoinChannelOrder qcoinChannelOrder,ChannelPlaceOrderResponse response){
        responseSyncFailOnChannel(qcoinChannelOrder,response);
        ThreadPoolManager.getInstance().execute(new NotifyMerchantTask(rechargeOrderService,qcoinChannelOrder.getOrderNo()));
    }

    private void responseSyncFailOnChannel(QcoinChannelOrder qcoinChannelOrder,ChannelPlaceOrderResponse response){
        qcoinChannelOrderService.updateByPlaceOrderResponse(qcoinChannelOrder,response);
        qcoinOrderService.updateStatus(qcoinChannelOrder);
        rechargeOrderService.updateStatus(qcoinChannelOrder.getOrderNo(),qcoinChannelOrder.getOrderState());
    }

    /**
     * 异步结果的处理
     * @param qcoinChannelOrder
     */
    private void responseAsyncSucessOnChannel(QcoinChannelOrder qcoinChannelOrder){
        responseAsyncFailOnChannel(qcoinChannelOrder);
        ThreadPoolManager.getInstance().execute(new NotifyMerchantTask(rechargeOrderService,qcoinChannelOrder.getOrderNo()));
    }

    /**
     * 异步结果的处理
     * @param qcoinChannelOrder
     */
    private void responseAsyncFailOnChannel(QcoinChannelOrder qcoinChannelOrder){
        qcoinOrderService.updateStatus(qcoinChannelOrder);
        rechargeOrderService.updateStatus(qcoinChannelOrder.getOrderNo(),qcoinChannelOrder.getOrderState());
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
        qcionOrder.setOrderNo(rechargeOrder.getOrderNo());
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
