package com.business.recharge.controller;

import com.business.recharge.entity.MerchantApplyBusiness;
import com.business.recharge.entity.MerchantInfo;
import com.business.recharge.entity.QcoinBlackList;
import com.business.recharge.entity.RechargeOrder;
import com.business.recharge.entity.enumtype.AccountStatus;
import com.business.recharge.entity.enumtype.RequestType;
import com.business.recharge.entity.enumtype.StatusType;
import com.business.recharge.exceptions.*;
import com.business.recharge.service.*;
import com.business.recharge.vo.PlaceOrderRequest;
import com.business.recharge.vo.PlaceOrderResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenll on 2017/6/23.
 */
@RestController
public class PlaceOrderController {

    private static Logger logger = LoggerFactory.getLogger(PlaceOrderController.class);

    @Autowired
    private MerchantInfoService merchantInfoService;

    @Autowired
    private MerchantApplyBusinessService merchantApplyBusinessService;

    @Autowired
    private QcoinBlackListService qcoinBlackListService;

    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private RechargeOrderService rechargeOrderService;

    private final static List<Integer> BUSINESSTYPES = Arrays.asList(10,11,12,13);

    @Autowired
    private RequestLogService requestLogService;

    @ApiOperation(value = "下单接口操作",notes = "")
    @RequestMapping(value = "/orders/place",method = RequestMethod.POST)
    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest){
        logger.info("请求订单参数,entity:{}",placeOrderRequest.toString());
        //记录日志
        requestLogService.saveLog(RequestType.PLACEORDER,placeOrderRequest.toString());
        this.validateRequest(placeOrderRequest);
        RechargeOrder rechareOrder = placeOrderService.processOrder(placeOrderRequest);
        PlaceOrderResponse response = new PlaceOrderResponse();
        response.setResultCode("01");
        response.setResultMsg("接单成功");
        response.setOrderNo(rechareOrder.getOrderNo());
        response.setMerAccount(rechareOrder.getMerchantAccount());
        return response;
    }

    private void validateRequest(PlaceOrderRequest placeOrderRequest){
        MerchantInfo merchantAccount = merchantInfoService.findByAccount(placeOrderRequest.getMerchantAccount());
        if (merchantAccount==null){
            throw new MerchantNotExistException();
        }
        //验证账户是否冻结
        Byte status = merchantAccount.getFrozenStatus();
        if (AccountStatus.FROZEN.getValue().byteValue()==status.byteValue()){
            throw new AccountFrozenException();
        }

        MerchantApplyBusiness merchantApplyBusiness = merchantApplyBusinessService.findBy(placeOrderRequest.getMerchantAccount(),placeOrderRequest.getBusinessType());
        if (merchantApplyBusiness == null){
            throw new AccountNoBusinessException();
        }
        if (AccountStatus.FROZEN.getValue().byteValue() == merchantApplyBusiness.getState().byteValue()){
            throw new AccountNoBusinessException();
        }
        //验证业务类型是否存在
        if (!BUSINESSTYPES.contains(placeOrderRequest.getBusinessType())){
            throw new BusinessTypeNotExistException();
        }

        //验证 placeOrderRequest.getMerchantOrderNo()在表中是否存在重复的
        int OrderNoNum = rechargeOrderService.verifyMercantOrderNo(placeOrderRequest.getMerchantAccount(),placeOrderRequest.getMerchantOrderNo());
        if (OrderNoNum > 0){
            throw new DuplicateMerchantOrderNOException();
        }
        //面额和数量对数字验证
        if (!NumberUtils.isNumber(String.valueOf(placeOrderRequest.getCharegeUnitValue()))){
            throw new ParamNotNumberException();
        }
        if (!NumberUtils.isNumber(String.valueOf(placeOrderRequest.getChargeNumber()))){
            throw new ParamNotNumberException();
        }

        QcoinBlackList qqBlack = qcoinBlackListService.findByNumber(placeOrderRequest.getChargeAccount());
        if (qqBlack!=null && qqBlack.getState().byteValue()== StatusType.NORMAL.getValue()){
            throw new QQInBlackListException();
        }
    }
}
