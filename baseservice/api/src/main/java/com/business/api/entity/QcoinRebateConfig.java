package com.business.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name = "qcoin_rebate_config_u")
public class QcoinRebateConfig extends BaseEntity {

    /**
     * 商户账号
     */
    @Column(name = "mer_account")
    private String merAccount;

    /**
     * 省份编号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 返佣折扣率
     */
    @Column(name = "discount_rate")
    private Double discountRate;

    /**
     * 状态:0不可用；1可用
     */
    private Integer state;


    /**
     * 获取商户账号
     *
     * @return mer_account - 商户账号
     */
    public String getMerAccount() {
        return merAccount;
    }

    /**
     * 设置商户账号
     *
     * @param merAccount 商户账号
     */
    public void setMerAccount(String merAccount) {
        this.merAccount = merAccount;
    }

    /**
     * 获取省份编号
     *
     * @return province_code - 省份编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省份编号
     *
     * @param provinceCode 省份编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取返佣折扣率
     *
     * @return discount_rate - 返佣折扣率
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置返佣折扣率
     *
     * @param discountRate 返佣折扣率
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 获取状态:0不可用；1可用
     *
     * @return state - 状态:0不可用；1可用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态:0不可用；1可用
     *
     * @param state 状态:0不可用；1可用
     */
    public void setState(Integer state) {
        this.state = state;
    }
}