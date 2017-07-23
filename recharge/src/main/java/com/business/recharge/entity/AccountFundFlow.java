package com.business.recharge.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "account_fund_flow")
public class AccountFundFlow extends BaseEntity{

    /**
     * 商户账号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 账号类型：0余额账户，1返佣账户
     */
    @Column(name = "account_type")
    private Integer accountType;

    /**
     * 变动前金额
     */
    @Column(name = "amount_before_change")
    private Long amountBeforeChange;

    /**
     * 变动金额:正负值表示账户加减
     */
    @Column(name = "change_amount")
    private Long changeAmount;

    /**
     * 变动后金额
     */
    @Column(name = "amount_after_change")
    private Long amountAfterChange;

    /**
     * 变动时间
     */
    @Column(name = "change_time")
    private Date changeTime;

    /**
     * 变动原因
     */
    @Column(name = "change_reason")
    private String changeReason;

    /**
     * 变动类型，1x未账户资金加；2x为账户资金减，详情dictionary_change_type
     */
    @Column(name = "change_type")
    private Integer changeType;

    /**
     * 引发变动的系统订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 引发变动的商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;


    /**
     * 获取商户账号
     *
     * @return merchant_account - 商户账号
     */
    public String getMerchantAccount() {
        return merchantAccount;
    }

    /**
     * 设置商户账号
     *
     * @param merchantAccount 商户账号
     */
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    /**
     * 获取账号类型：0余额账户，1返佣账户
     *
     * @return account_type - 账号类型：0余额账户，1返佣账户
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型：0余额账户，1返佣账户
     *
     * @param accountType 账号类型：0余额账户，1返佣账户
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取变动前金额
     *
     * @return amount_before_change - 变动前金额
     */
    public Long getAmountBeforeChange() {
        return amountBeforeChange;
    }

    /**
     * 设置变动前金额
     *
     * @param amountBeforeChange 变动前金额
     */
    public void setAmountBeforeChange(Long amountBeforeChange) {
        this.amountBeforeChange = amountBeforeChange;
    }

    /**
     * 获取变动金额:正负值表示账户加减
     *
     * @return change_amount - 变动金额:正负值表示账户加减
     */
    public Long getChangeAmount() {
        return changeAmount;
    }

    /**
     * 设置变动金额:正负值表示账户加减
     *
     * @param changeAmount 变动金额:正负值表示账户加减
     */
    public void setChangeAmount(Long changeAmount) {
        this.changeAmount = changeAmount;
    }

    /**
     * 获取变动后金额
     *
     * @return amount_after_change - 变动后金额
     */
    public Long getAmountAfterChange() {
        return amountAfterChange;
    }

    /**
     * 设置变动后金额
     *
     * @param amountAfterChange 变动后金额
     */
    public void setAmountAfterChange(Long amountAfterChange) {
        this.amountAfterChange = amountAfterChange;
    }

    /**
     * 获取变动时间
     *
     * @return change_time - 变动时间
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * 设置变动时间
     *
     * @param changeTime 变动时间
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取变动原因
     *
     * @return change_reason - 变动原因
     */
    public String getChangeReason() {
        return changeReason;
    }

    /**
     * 设置变动原因
     *
     * @param changeReason 变动原因
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    /**
     * 获取变动类型，1x未账户资金加；2x为账户资金减，详情dictionary_change_type
     *
     * @return change_type - 变动类型，1x未账户资金加；2x为账户资金减，详情dictionary_change_type
     */
    public Integer getChangeType() {
        return changeType;
    }

    /**
     * 设置变动类型，1x未账户资金加；2x为账户资金减，详情dictionary_change_type
     *
     * @param changeType 变动类型，1x未账户资金加；2x为账户资金减，详情dictionary_change_type
     */
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    /**
     * 获取引发变动的系统订单号
     *
     * @return order_no - 引发变动的系统订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置引发变动的系统订单号
     *
     * @param orderNo 引发变动的系统订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取引发变动的商户订单号
     *
     * @return merchant_order_no - 引发变动的商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置引发变动的商户订单号
     *
     * @param merchantOrderNo 引发变动的商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}