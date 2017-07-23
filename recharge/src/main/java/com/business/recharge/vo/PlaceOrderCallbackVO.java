package com.business.recharge.vo;

import java.util.Date;

/**
 * Created by chenll on 2017/7/16.
 */
public class PlaceOrderCallbackVO {

    private String merchantAccount;

    private Integer businessType;

    //我们自己的订单号
    private String merchantOrderNo;

    //请求的时间
    private Date merchantRequetTime;

    //上游渠道产生的订单号
    private String orderNo;

    private Date orderTime;

    private Long orderAmount;

    private Long payAmount;

    private Long discountAmount;

    private Long successAmount;

    private String orderDetail;

    private Integer orderStatus;
    private String attach;

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public Date getMerchantRequetTime() {
        return merchantRequetTime;
    }

    public void setMerchantRequetTime(Date merchantRequetTime) {
        this.merchantRequetTime = merchantRequetTime;
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

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Long getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(Long successAmount) {
        this.successAmount = successAmount;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
