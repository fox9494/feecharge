package com.business.recharge.channel.jiaoyiba;


import com.business.recharge.channel.ChannelBusinessService;
import com.business.recharge.utils.HttpUtil;
import com.business.recharge.vo.ChannelPlaceOrderRequest;
import com.business.recharge.vo.ChannelPlaceOrderResponse;
import com.business.recharge.vo.ChannelQueryOrderReponse;
import com.business.recharge.vo.ChannelQueryOrderRequest;

/**
 * Created by chenll on 2017/7/15.
 */
public class JiaoyibaBusinessService implements ChannelBusinessService {


    public ChannelPlaceOrderResponse requestChannelPlaceOrder(ChannelPlaceOrderRequest request) {
        String result = HttpUtil.doPost("www.sina.com","{'a':'b','c':'d'}");//TODO
        return null;
    }

    public ChannelQueryOrderReponse requestChannelQueryOrder(ChannelQueryOrderRequest request) {
        return null;
    }
}
