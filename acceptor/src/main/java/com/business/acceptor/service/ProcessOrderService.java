package com.business.acceptor.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.business.acceptor.producer.OrderProducer;
import com.business.api.entity.enumtype.RequestType;
import com.business.api.service.PlaceOrderService;
import com.business.api.vo.PlaceOrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chenll on 2017/6/24.
 * 下单业务
 */
@Component
public class ProcessOrderService {

    private static Logger logger = LoggerFactory.getLogger(ProcessOrderService.class);


    @Autowired
    private OrderProducer orderProducer;

    @Reference
    private PlaceOrderService placeOrderService;

    public void saveLog(RequestType requestType, String data){
        placeOrderService.saveLog(requestType,data);
    }

    public void handleOrder(PlaceOrderRequest placeOrderRequest){
        com.business.api.entity.RechargeOrder rechargeOrder = placeOrderService.processOrder(placeOrderRequest);

        //发kafka
        orderProducer.send(OrderProducer.TOPIC_ORDER,rechargeOrder);

        logger.info("商户:{} 接单成功,orderNo:{}",placeOrderRequest.getMerchantAccount(),rechargeOrder.getOrderNo());
    }

}
