package com.business.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "merchant_account_info")
public class MerchantAccountInfo extends BaseEntity {

    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 账户类型：0余额账号；1返佣账号
     */
    private Byte type;

    /**
     * 账户余额(厘)
     */
    private Long balance;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;

    /**
     * @return merchant_account
     */
    public String getMerchantAccount() {
        return merchantAccount;
    }

    /**
     * @param merchantAccount
     */
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    /**
     * 获取账户类型：0余额账号；1返佣账号
     *
     * @return type - 账户类型：0余额账号；1返佣账号
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置账户类型：0余额账号；1返佣账号
     *
     * @param type 账户类型：0余额账号；1返佣账号
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取账户余额(厘)
     *
     * @return balance - 账户余额(厘)
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置账户余额(厘)
     *
     * @param balance 账户余额(厘)
     */
    public void setBalance(Long balance) {
        this.balance = balance;
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