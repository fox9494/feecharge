package com.business.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenll on 2017/7/5.
 */
public class PlaceOrderRequest extends BaseRequest implements Serializable{

    private String merchantAccount;

    private Integer businessType;

    private String merchantOrderNo;

    private Date merchantRequestTime;

    private String expandAccount;

    private String chargeAccount;

    private Long charegeUnitValue;

    private Long chargeNumber;

    private String expandParam;

    //附加字段
    private String attach;

    private String customerIp;

    private String notifyUrl;

    private String sign;

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

    public Date getMerchantRequestTime() {
        return merchantRequestTime;
    }

    public void setMerchantRequestTime(Date merchantRequestTime) {
        this.merchantRequestTime = merchantRequestTime;
    }

    public String getExpandAccount() {
        return expandAccount;
    }

    public void setExpandAccount(String expandAccount) {
        this.expandAccount = expandAccount;
    }

    public String getChargeAccount() {
        return chargeAccount;
    }

    public void setChargeAccount(String chargeAccount) {
        this.chargeAccount = chargeAccount;
    }

    public Long getCharegeUnitValue() {
        return charegeUnitValue;
    }

    public void setCharegeUnitValue(Long charegeUnitValue) {
        this.charegeUnitValue = charegeUnitValue;
    }

    public Long getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(Long chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public String getExpandParam() {
        return expandParam;
    }

    public void setExpandParam(String expandParam) {
        this.expandParam = expandParam;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
