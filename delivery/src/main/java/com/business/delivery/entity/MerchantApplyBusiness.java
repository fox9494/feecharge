package com.business.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "merchant_apply_business")
public class MerchantApplyBusiness extends BaseEntity{

    /**
     * 商户账号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 商户名
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 业务类型
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 业务申请时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 申请状态：0申请未通过；1申请通过
     */
    @Column(name = "apply_state")
    private Byte applyState;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;

    /**
     * 返佣类型:0前返佣；1后返佣
     */
    @Column(name = "rebate_type")
    private Byte rebateType;

    /**
     * 状态：1可用；0不可用
     */
    private Byte state;

    /**
     * 商户请求改业务的最小金额(厘)
     */
    @Column(name = "min_amount")
    private Long minAmount;

    /**
     * 商户走该业务的最大金额
     */
    @Column(name = "max_amount")
    private Long maxAmount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_by")
    private String createBy;


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
     * 获取商户名
     *
     * @return merchant_name - 商户名
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 设置商户名
     *
     * @param merchantName 商户名
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 获取业务类型
     *
     * @return business_type - 业务类型
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型
     *
     * @param businessType 业务类型
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取业务申请时间
     *
     * @return apply_time - 业务申请时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置业务申请时间
     *
     * @param applyTime 业务申请时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取申请状态：0申请未通过；1申请通过
     *
     * @return apply_state - 申请状态：0申请未通过；1申请通过
     */
    public Byte getApplyState() {
        return applyState;
    }

    /**
     * 设置申请状态：0申请未通过；1申请通过
     *
     * @param applyState 申请状态：0申请未通过；1申请通过
     */
    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    /**
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取返佣类型:0前返佣；1后返佣
     *
     * @return rebate_type - 返佣类型:0前返佣；1后返佣
     */
    public Byte getRebateType() {
        return rebateType;
    }

    /**
     * 设置返佣类型:0前返佣；1后返佣
     *
     * @param rebateType 返佣类型:0前返佣；1后返佣
     */
    public void setRebateType(Byte rebateType) {
        this.rebateType = rebateType;
    }

    /**
     * 获取状态：1可用；0不可用
     *
     * @return state - 状态：1可用；0不可用
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置状态：1可用；0不可用
     *
     * @param state 状态：1可用；0不可用
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取商户请求改业务的最小金额(厘)
     *
     * @return min_amount - 商户请求改业务的最小金额(厘)
     */
    public Long getMinAmount() {
        return minAmount;
    }

    /**
     * 设置商户请求改业务的最小金额(厘)
     *
     * @param minAmount 商户请求改业务的最小金额(厘)
     */
    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * 获取商户走该业务的最大金额
     *
     * @return max_amount - 商户走该业务的最大金额
     */
    public Long getMaxAmount() {
        return maxAmount;
    }

    /**
     * 设置商户走该业务的最大金额
     *
     * @param maxAmount 商户走该业务的最大金额
     */
    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
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
}