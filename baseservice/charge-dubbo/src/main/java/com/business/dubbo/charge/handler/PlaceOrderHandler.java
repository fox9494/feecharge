package com.business.dubbo.charge.handler;

import com.alibaba.dubbo.config.annotation.Service;
import com.business.api.entity.RechargeOrder;
import com.business.api.entity.enumtype.RequestType;
import com.business.api.service.PlaceOrderApiService;
import com.business.api.vo.PlaceOrderRequest;
import com.business.dubbo.charge.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenll on 2017/7/7.
 */
@Service
public class PlaceOrderHandler implements PlaceOrderApiService {

    @Autowired
    private PlaceOrderService placeOrderServiceImpl;

    public RechargeOrder processOrder(PlaceOrderRequest placeOrderRequest) {
       return placeOrderServiceImpl.processOrder(placeOrderRequest);
    }

    public void saveLog(RequestType requestType, String data) {

    }
}
