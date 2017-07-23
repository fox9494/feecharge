package com.business.recharge.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "qcoin_merchant_usable_channel")
public class QcoinMerchantUsableChannel extends BaseEntity{

    /**
     * 商户编号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 渠道编号
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 部分成功是否走下一渠道：0不走；1要走
     */
    @Column(name = "part_go_next")
    private Integer partGoNext;

    /**
     * 全部失败是否走下一渠道：0不走；1要走
     */
    @Column(name = "fail_go_next")
    private Integer failGoNext;

    /**
     * 商户渠道最小金额(厘)
     */
    @Column(name = "min_amount")
    private Long minAmount;

    /**
     * 商户渠道最大金额(厘)
     */
    @Column(name = "max_amount")
    private Long maxAmount;

    /**
     * 当前数据是否可用：0不可用；1可用
     */
    private Integer state;

    /**
     * 拆单类型:0按照顺序拆分，1固定面值拆分；2固定面值重复拆分
     */
    @Column(name = "split_type")
    private Integer splitType;

    /**
     * 金额拆分规则，单位是元，多个采用英文逗号分开
     */
    @Column(name = "split_rule")
    private String splitRule;

    /**
     * 是否允许不确定的IP走该渠道:0不允许；1允许
     */
    @Column(name = "allow_unsure_province")
    private Integer allowUnsureProvince;

    /**
     * 允许走的省份
     */
    @Column(name = "allow_province")
    private String allowProvince;

    private Integer orderSort;

    public Integer getOrderSort() {
        return orderSort;
    }

    public void setOrderSort(Integer orderSort) {
        this.orderSort = orderSort;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取部分成功是否走下一渠道：0不走；1要走
     *
     * @return part_go_next - 部分成功是否走下一渠道：0不走；1要走
     */
    public Integer getPartGoNext() {
        return partGoNext;
    }

    /**
     * 设置部分成功是否走下一渠道：0不走；1要走
     *
     * @param partGoNext 部分成功是否走下一渠道：0不走；1要走
     */
    public void setPartGoNext(Integer partGoNext) {
        this.partGoNext = partGoNext;
    }

    /**
     * 获取全部失败是否走下一渠道：0不走；1要走
     *
     * @return fail_go_next - 全部失败是否走下一渠道：0不走；1要走
     */
    public Integer getFailGoNext() {
        return failGoNext;
    }

    /**
     * 设置全部失败是否走下一渠道：0不走；1要走
     *
     * @param failGoNext 全部失败是否走下一渠道：0不走；1要走
     */
    public void setFailGoNext(Integer failGoNext) {
        this.failGoNext = failGoNext;
    }

    /**
     * 获取商户渠道最小金额(厘)
     *
     * @return min_amount - 商户渠道最小金额(厘)
     */
    public Long getMinAmount() {
        return minAmount;
    }

    /**
     * 设置商户渠道最小金额(厘)
     *
     * @param minAmount 商户渠道最小金额(厘)
     */
    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * 获取商户渠道最大金额(厘)
     *
     * @return max_amount - 商户渠道最大金额(厘)
     */
    public Long getMaxAmount() {
        return maxAmount;
    }

    /**
     * 设置商户渠道最大金额(厘)
     *
     * @param maxAmount 商户渠道最大金额(厘)
     */
    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * 获取当前数据是否可用：0不可用；1可用
     *
     * @return state - 当前数据是否可用：0不可用；1可用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置当前数据是否可用：0不可用；1可用
     *
     * @param state 当前数据是否可用：0不可用；1可用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取拆单类型:0按照顺序拆分，1固定面值拆分；2固定面值重复拆分
     *
     * @return split_type - 拆单类型:0按照顺序拆分，1固定面值拆分；2固定面值重复拆分
     */
    public Integer getSplitType() {
        return splitType;
    }

    /**
     * 设置拆单类型:0按照顺序拆分，1固定面值拆分；2固定面值重复拆分
     *
     * @param splitType 拆单类型:0按照顺序拆分，1固定面值拆分；2固定面值重复拆分
     */
    public void setSplitType(Integer splitType) {
        this.splitType = splitType;
    }

    /**
     * 获取金额拆分规则，单位是元，多个采用英文逗号分开
     *
     * @return split_rule - 金额拆分规则，单位是元，多个采用英文逗号分开
     */
    public String getSplitRule() {
        return splitRule;
    }

    /**
     * 设置金额拆分规则，单位是元，多个采用英文逗号分开
     *
     * @param splitRule 金额拆分规则，单位是元，多个采用英文逗号分开
     */
    public void setSplitRule(String splitRule) {
        this.splitRule = splitRule;
    }

    /**
     * 获取是否允许不确定的IP走该渠道:0不允许；1允许
     *
     * @return allow_unsure_province - 是否允许不确定的IP走该渠道:0不允许；1允许
     */
    public Integer getAllowUnsureProvince() {
        return allowUnsureProvince;
    }

    /**
     * 设置是否允许不确定的IP走该渠道:0不允许；1允许
     *
     * @param allowUnsureProvince 是否允许不确定的IP走该渠道:0不允许；1允许
     */
    public void setAllowUnsureProvince(Integer allowUnsureProvince) {
        this.allowUnsureProvince = allowUnsureProvince;
    }

    /**
     * 获取允许走的省份
     *
     * @return allow_province - 允许走的省份
     */
    public String getAllowProvince() {
        return allowProvince;
    }

    /**
     * 设置允许走的省份
     *
     * @param allowProvince 允许走的省份
     */
    public void setAllowProvince(String allowProvince) {
        this.allowProvince = allowProvince;
    }
}