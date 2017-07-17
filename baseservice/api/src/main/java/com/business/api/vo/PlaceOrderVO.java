package com.business.api.vo;

import java.util.Date;

/**
 * Created by chenll on 2017/7/16.
 */
public class PlaceOrderVO {

    private String merchantAccount;

    private Integer businessType;

    //针对上游渠道产生的订单号
    private String channelOrderNo;

    //请求的时间
    private Date requestTime;

    private String extendAccount;

    private String rechargeAccount;

    private Long rechargeValue;

    private Long rechargeNum;

    private String extendParam;

    private String attach;

    private String customerIp;

    private String notifyUrl;

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

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getExtendAccount() {
        return extendAccount;
    }

    public void setExtendAccount(String extendAccount) {
        this.extendAccount = extendAccount;
    }

    public String getRechargeAccount() {
        return rechargeAccount;
    }

    public void setRechargeAccount(String rechargeAccount) {
        this.rechargeAccount = rechargeAccount;
    }

    public Long getRechargeValue() {
        return rechargeValue;
    }

    public void setRechargeValue(Long rechargeValue) {
        this.rechargeValue = rechargeValue;
    }

    public Long getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(Long rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
