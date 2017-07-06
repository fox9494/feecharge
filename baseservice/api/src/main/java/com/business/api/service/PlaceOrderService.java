package com.business.api.service;

import com.business.api.entity.RechargeOrder;
import com.business.api.vo.PlaceOrderRequest;

/**
 * Created by chenll on 2017/7/6.
 */
public interface PlaceOrderService {

    /**
     * 处理接单流程
     * @param placeOrderRequest
     * @return
     */
    public RechargeOrder processOrder(PlaceOrderRequest placeOrderRequest);
}
