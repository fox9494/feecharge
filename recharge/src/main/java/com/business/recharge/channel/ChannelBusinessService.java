package com.business.recharge.channel;


import com.business.recharge.vo.ChannelPlaceOrderRequest;
import com.business.recharge.vo.ChannelPlaceOrderResponse;
import com.business.recharge.vo.ChannelQueryOrderReponse;
import com.business.recharge.vo.ChannelQueryOrderRequest;

/**
 * Created by chenll on 2017/7/15.
 */
public interface ChannelBusinessService {

    public ChannelPlaceOrderResponse requestChannelPlaceOrder(ChannelPlaceOrderRequest request);

    public ChannelQueryOrderReponse requestChannelQueryOrder(ChannelQueryOrderRequest request);

}
