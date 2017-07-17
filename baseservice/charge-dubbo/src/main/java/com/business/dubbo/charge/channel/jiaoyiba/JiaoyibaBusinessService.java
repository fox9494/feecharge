package com.business.dubbo.charge.channel.jiaoyiba;

import com.business.api.vo.ChannelPlaceOrderRequest;
import com.business.api.vo.ChannelPlaceOrderResponse;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.api.vo.ChannelQueryOrderRequest;
import com.business.dubbo.charge.channel.ChannelBusinessService;
import com.business.dubbo.charge.utils.HttpUtil;

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
