package com.business.dubbo.charge.channel;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.vo.ChannelPlaceOrderRequest;
import com.business.api.vo.ChannelPlaceOrderResponse;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.api.vo.ChannelQueryOrderRequest;

/**
 * Created by chenll on 2017/7/15.
 */
public interface ChannelBusinessService {

    public ChannelPlaceOrderResponse requestChannelPlaceOrder(ChannelPlaceOrderRequest request);

    public ChannelQueryOrderReponse requestChannelQueryOrder(ChannelQueryOrderRequest request);

}
