package com.business.api.service;

import com.business.api.entity.RechargeOrder;
import com.business.api.entity.enumtype.RequestType;
import com.business.api.vo.PlaceOrderRequest;

/**
 * Created by chenll on 2017/7/6.
 */
public interface PlaceOrderApiService {

    /**
     * 处理接单流程
     * @param placeOrderRequest
     * @return
     */
    public RechargeOrder processOrder(PlaceOrderRequest placeOrderRequest);

    public void saveLog(RequestType requestType, String data);
}
