package com.business.callback.controller;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.vo.ChannelPlaceOrderCallbackRequest;
import com.business.api.vo.ChannelPlaceOrderCallbackResponse;
import com.business.api.vo.PlaceOrderCallbackVO;
import com.business.dubbo.charge.service.QcoinChannelOrderService;
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

    private QcoinChannelOrderService qcoinChannelOrderService;



    @ApiOperation(value = "交易吧下单回调操作",notes = "")
    @RequestMapping(value = "/callback/orders/place",method = RequestMethod.POST)
    public ChannelPlaceOrderCallbackResponse placeOrder(@RequestBody ChannelPlaceOrderCallbackRequest channelPlaceOrderCallbackRequest){
        logger.info("下单回调,entity:{}",channelPlaceOrderCallbackRequest.toString());
        //记录日志
        PlaceOrderCallbackVO vo = channelPlaceOrderCallbackRequest.getPlaceOrderCallbackVO();

        QcoinChannelOrder qcoinChannelOrder = qcoinChannelOrderService.findByAccountAndOrderNo(null, vo.getMerchantOrderNo());
        qcoinChannelOrderService.updateByPlaceOrderCallbackResponse(qcoinChannelOrder,channelPlaceOrderCallbackRequest);
        ChannelPlaceOrderCallbackResponse response = new ChannelPlaceOrderCallbackResponse();
        response.setResult("OK");
        return response;
    }
}
