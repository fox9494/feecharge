package com.business.acceptor.vo;

import com.business.acceptor.entity.enumtype.OrderStatus;
import com.business.acceptor.entity.enumtype.OrderType;

import java.util.Date;

/**
 * Created by chenll on 2017/6/23.
 */
public class PlaceOrderResponse {

    private String resultCode;

    private String resultMsg;

    private String merAccount;

    private String merUserAccount;

    private OrderType orderType;

    private String merOrderNo;

    private Date merOrderTime;

    private String orderNo;

    private Date orderTime;

    //以厘为单位
    private Long orderAmount;

    private Long payAmount;

    private String orderDetail;

    private OrderStatus orderStatus;

    private String orderStateDesc;

    private String attach;

    private String sign;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getMerAccount() {
        return merAccount;
    }

    public void setMerAccount(String merAccount) {
        this.merAccount = merAccount;
    }

    public String getMerUserAccount() {
        return merUserAccount;
    }

    public void setMerUserAccount(String merUserAccount) {
        this.merUserAccount = merUserAccount;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getMerOrderNo() {
        return merOrderNo;
    }

    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public Date getMerOrderTime() {
        return merOrderTime;
    }

    public void setMerOrderTime(Date merOrderTime) {
        this.merOrderTime = merOrderTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStateDesc() {
        return orderStateDesc;
    }

    public void setOrderStateDesc(String orderStateDesc) {
        this.orderStateDesc = orderStateDesc;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
