package com.business.callback.controller;

import com.business.api.vo.ChannelPlaceOrderCallbackRequest;
import com.business.api.vo.ChannelPlaceOrderCallbackResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenll on 2017/6/23.
 * 对接交易吧回调
 */
@RestController
public class JiaoyibaCallbackController {

    private static Logger logger = LoggerFactory.getLogger(JiaoyibaCallbackController.class);



    @ApiOperation(value = "交易吧下单回调操作",notes = "")
    @RequestMapping(value = "/callback/orders/place",method = RequestMethod.POST)
    public ChannelPlaceOrderCallbackResponse placeOrder(@RequestBody ChannelPlaceOrderCallbackRequest channelPlaceOrderCallbackRequest){
        logger.info("下单回调,entity:{}",channelPlaceOrderCallbackRequest.toString());
        //记录日志

        return null;
    }
}
