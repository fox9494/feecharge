package com.business.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "qcoin_merchant_split_config")
public class QcoinMerchantSplitConfig extends BaseEntity{

    /**
     * 商户账号
     */
    @Column(name = "mer_account")
    private String merAccount;

    /**
     * 拆单状态:1允许拆单；0不允许拆单
     */
    @Column(name = "split_state")
    private Integer splitState;

    /**
     * 是否允许走直通车:0不允许；1允许
     */
    @Column(name = "tencent_esales")
    private Integer tencentEsales;

    /**
     * 是否允许不可识别的IP地址下单:0不允许；1允许
     */
    @Column(name = "allow_illegal_ip")
    private Integer allowIllegalIp;

    /**
     * 是否信任商户IP：0不信任；1信任
     */
    @Column(name = "trust_ip")
    private Integer trustIp;

    /**
     * 是否允许非法QQ充值：0不允许，1允许（允许情况或被尽可能置为成功）
     */
    @Column(name = "allow_illegal_account")
    private Integer allowIllegalAccount;

    /**
     * 是否允许电话号码充值：0不允许；1允许
     */
    @Column(name = "allow_phone_account")
    private Integer allowPhoneAccount;

    /**
     * 是否允许循环账号：0不允许；1允许
     */
    @Column(name = "allow_repeat_account")
    private Integer allowRepeatAccount;

    /**
     * 保存信任的IP省份信息，此字段在trust_ip为1时生效
     */
    @Column(name = "save_trust_ip_province")
    private String saveTrustIpProvince;

    /**
     * 是否允许亏损:0不允许；1允许
     */
    @Column(name = "allow_loss")
    private Integer allowLoss;

    /**
     * 默认的折扣省份
     */
    @Column(name = "default_discount_province")
    private String defaultDiscountProvince;


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
     * 获取拆单状态:1允许拆单；0不允许拆单
     *
     * @return split_state - 拆单状态:1允许拆单；0不允许拆单
     */
    public Integer getSplitState() {
        return splitState;
    }

    /**
     * 设置拆单状态:1允许拆单；0不允许拆单
     *
     * @param splitState 拆单状态:1允许拆单；0不允许拆单
     */
    public void setSplitState(Integer splitState) {
        this.splitState = splitState;
    }

    /**
     * 获取是否允许走直通车:0不允许；1允许
     *
     * @return tencent_esales - 是否允许走直通车:0不允许；1允许
     */
    public Integer getTencentEsales() {
        return tencentEsales;
    }

    /**
     * 设置是否允许走直通车:0不允许；1允许
     *
     * @param tencentEsales 是否允许走直通车:0不允许；1允许
     */
    public void setTencentEsales(Integer tencentEsales) {
        this.tencentEsales = tencentEsales;
    }

    /**
     * 获取是否允许不可识别的IP地址下单:0不允许；1允许
     *
     * @return allow_illegal_ip - 是否允许不可识别的IP地址下单:0不允许；1允许
     */
    public Integer getAllowIllegalIp() {
        return allowIllegalIp;
    }

    /**
     * 设置是否允许不可识别的IP地址下单:0不允许；1允许
     *
     * @param allowIllegalIp 是否允许不可识别的IP地址下单:0不允许；1允许
     */
    public void setAllowIllegalIp(Integer allowIllegalIp) {
        this.allowIllegalIp = allowIllegalIp;
    }

    /**
     * 获取是否信任商户IP：0不信任；1信任
     *
     * @return trust_ip - 是否信任商户IP：0不信任；1信任
     */
    public Integer getTrustIp() {
        return trustIp;
    }

    /**
     * 设置是否信任商户IP：0不信任；1信任
     *
     * @param trustIp 是否信任商户IP：0不信任；1信任
     */
    public void setTrustIp(Integer trustIp) {
        this.trustIp = trustIp;
    }

    /**
     * 获取是否允许非法QQ充值：0不允许，1允许（允许情况或被尽可能置为成功）
     *
     * @return allow_illegal_account - 是否允许非法QQ充值：0不允许，1允许（允许情况或被尽可能置为成功）
     */
    public Integer getAllowIllegalAccount() {
        return allowIllegalAccount;
    }

    /**
     * 设置是否允许非法QQ充值：0不允许，1允许（允许情况或被尽可能置为成功）
     *
     * @param allowIllegalAccount 是否允许非法QQ充值：0不允许，1允许（允许情况或被尽可能置为成功）
     */
    public void setAllowIllegalAccount(Integer allowIllegalAccount) {
        this.allowIllegalAccount = allowIllegalAccount;
    }

    /**
     * 获取是否允许电话号码充值：0不允许；1允许
     *
     * @return allow_phone_account - 是否允许电话号码充值：0不允许；1允许
     */
    public Integer getAllowPhoneAccount() {
        return allowPhoneAccount;
    }

    /**
     * 设置是否允许电话号码充值：0不允许；1允许
     *
     * @param allowPhoneAccount 是否允许电话号码充值：0不允许；1允许
     */
    public void setAllowPhoneAccount(Integer allowPhoneAccount) {
        this.allowPhoneAccount = allowPhoneAccount;
    }

    /**
     * 获取是否允许循环账号：0不允许；1允许
     *
     * @return allow_repeat_account - 是否允许循环账号：0不允许；1允许
     */
    public Integer getAllowRepeatAccount() {
        return allowRepeatAccount;
    }

    /**
     * 设置是否允许循环账号：0不允许；1允许
     *
     * @param allowRepeatAccount 是否允许循环账号：0不允许；1允许
     */
    public void setAllowRepeatAccount(Integer allowRepeatAccount) {
        this.allowRepeatAccount = allowRepeatAccount;
    }

    /**
     * 获取保存信任的IP省份信息，此字段在trust_ip为1时生效
     *
     * @return save_trust_ip_province - 保存信任的IP省份信息，此字段在trust_ip为1时生效
     */
    public String getSaveTrustIpProvince() {
        return saveTrustIpProvince;
    }

    /**
     * 设置保存信任的IP省份信息，此字段在trust_ip为1时生效
     *
     * @param saveTrustIpProvince 保存信任的IP省份信息，此字段在trust_ip为1时生效
     */
    public void setSaveTrustIpProvince(String saveTrustIpProvince) {
        this.saveTrustIpProvince = saveTrustIpProvince;
    }

    /**
     * 获取是否允许亏损:0不允许；1允许
     *
     * @return allow_loss - 是否允许亏损:0不允许；1允许
     */
    public Integer getAllowLoss() {
        return allowLoss;
    }

    /**
     * 设置是否允许亏损:0不允许；1允许
     *
     * @param allowLoss 是否允许亏损:0不允许；1允许
     */
    public void setAllowLoss(Integer allowLoss) {
        this.allowLoss = allowLoss;
    }

    /**
     * 获取默认的折扣省份
     *
     * @return default_discount_province - 默认的折扣省份
     */
    public String getDefaultDiscountProvince() {
        return defaultDiscountProvince;
    }

    /**
     * 设置默认的折扣省份
     *
     * @param defaultDiscountProvince 默认的折扣省份
     */
    public void setDefaultDiscountProvince(String defaultDiscountProvince) {
        this.defaultDiscountProvince = defaultDiscountProvince;
    }
}