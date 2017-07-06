package com.business.acceptor.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "merchant_info")
public class MerchantInfo extends BaseEntity{

    /**
     * 商户账号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 商户名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 公司
     */
    private String company;

    /**
     * 公司地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    private String phone;

    /**
     * 邮件通知地址
     */
    private String email;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    /**
     * 登录密码=MD5(d鞥路密码原文+登录salt)
     */
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 登录salt
     */
    @Column(name = "login_salt")
    private String loginSalt;

    /**
     * 冻结状态:1未冻结；0冻结
     */
    @Column(name = "frozen_status")
    private Byte frozenStatus;

    /**
     * 审核状态:0未审核；1审核通过；2审核未通过
     */
    @Column(name = "check_status")
    private Byte checkStatus;

    /**
     * 上次登录IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最近登陆地址
     */
    @Column(name = "last_login_address")
    private String lastLoginAddress;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 本次登陆IP
     */
    @Column(name = "this_login_ip")
    private String thisLoginIp;

    /**
     * 本次登陆地址
     */
    @Column(name = "this_login_address")
    private String thisLoginAddress;

    @Column(name = "this_login_time")
    private Date thisLoginTime;

    /**
     * 商户报警开关，0表示不需要报警；1表示需要报警
     */
    @Column(name = "balance_notify_switch")
    private Byte balanceNotifySwitch;

    /**
     * 余额报警阀值（厘），余额低于此值时会触发报警
     */
    @Column(name = "balance_notify_amount")
    private Long balanceNotifyAmount;

    /**
     * 余额报警通知地址，不存在时不通知
     */
    @Column(name = "balance_notify_url")
    private String balanceNotifyUrl;

    /**
     * 商户通信请求密钥
     */
    @Column(name = "sign_key")
    private String signKey;

    /**
     * 允许通知:0不允许；1允许
     */
    @Column(name = "allow_notify")
    private Integer allowNotify;

    @Column(name = "company_comments")
    private String companyComments;


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
     * 获取商户名称
     *
     * @return merchant_name - 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 设置商户名称
     *
     * @param merchantName 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 获取公司
     *
     * @return company - 公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司
     *
     * @param company 公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取公司地址
     *
     * @return company_address - 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司地址
     *
     * @param companyAddress 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮件通知地址
     *
     * @return email - 邮件通知地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件通知地址
     *
     * @param email 邮件通知地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取登录密码=MD5(d鞥路密码原文+登录salt)
     *
     * @return login_pwd - 登录密码=MD5(d鞥路密码原文+登录salt)
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置登录密码=MD5(d鞥路密码原文+登录salt)
     *
     * @param loginPwd 登录密码=MD5(d鞥路密码原文+登录salt)
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * 获取登录salt
     *
     * @return login_salt - 登录salt
     */
    public String getLoginSalt() {
        return loginSalt;
    }

    /**
     * 设置登录salt
     *
     * @param loginSalt 登录salt
     */
    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }

    /**
     * 获取冻结状态:1未冻结；0冻结
     *
     * @return frozen_status - 冻结状态:1未冻结；0冻结
     */
    public Byte getFrozenStatus() {
        return frozenStatus;
    }

    /**
     * 设置冻结状态:1未冻结；0冻结
     *
     * @param frozenStatus 冻结状态:1未冻结；0冻结
     */
    public void setFrozenStatus(Byte frozenStatus) {
        this.frozenStatus = frozenStatus;
    }

    /**
     * 获取审核状态:0未审核；1审核通过；2审核未通过
     *
     * @return check_status - 审核状态:0未审核；1审核通过；2审核未通过
     */
    public Byte getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置审核状态:0未审核；1审核通过；2审核未通过
     *
     * @param checkStatus 审核状态:0未审核；1审核通过；2审核未通过
     */
    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取上次登录IP
     *
     * @return last_login_ip - 上次登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置上次登录IP
     *
     * @param lastLoginIp 上次登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最近登陆地址
     *
     * @return last_login_address - 最近登陆地址
     */
    public String getLastLoginAddress() {
        return lastLoginAddress;
    }

    /**
     * 设置最近登陆地址
     *
     * @param lastLoginAddress 最近登陆地址
     */
    public void setLastLoginAddress(String lastLoginAddress) {
        this.lastLoginAddress = lastLoginAddress;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取本次登陆IP
     *
     * @return this_login_ip - 本次登陆IP
     */
    public String getThisLoginIp() {
        return thisLoginIp;
    }

    /**
     * 设置本次登陆IP
     *
     * @param thisLoginIp 本次登陆IP
     */
    public void setThisLoginIp(String thisLoginIp) {
        this.thisLoginIp = thisLoginIp;
    }

    /**
     * 获取本次登陆地址
     *
     * @return this_login_address - 本次登陆地址
     */
    public String getThisLoginAddress() {
        return thisLoginAddress;
    }

    /**
     * 设置本次登陆地址
     *
     * @param thisLoginAddress 本次登陆地址
     */
    public void setThisLoginAddress(String thisLoginAddress) {
        this.thisLoginAddress = thisLoginAddress;
    }

    /**
     * @return this_login_time
     */
    public Date getThisLoginTime() {
        return thisLoginTime;
    }

    /**
     * @param thisLoginTime
     */
    public void setThisLoginTime(Date thisLoginTime) {
        this.thisLoginTime = thisLoginTime;
    }

    /**
     * 获取商户报警开关，0表示不需要报警；1表示需要报警
     *
     * @return balance_notify_switch - 商户报警开关，0表示不需要报警；1表示需要报警
     */
    public Byte getBalanceNotifySwitch() {
        return balanceNotifySwitch;
    }

    /**
     * 设置商户报警开关，0表示不需要报警；1表示需要报警
     *
     * @param balanceNotifySwitch 商户报警开关，0表示不需要报警；1表示需要报警
     */
    public void setBalanceNotifySwitch(Byte balanceNotifySwitch) {
        this.balanceNotifySwitch = balanceNotifySwitch;
    }

    /**
     * 获取余额报警阀值（厘），余额低于此值时会触发报警
     *
     * @return balance_notify_amount - 余额报警阀值（厘），余额低于此值时会触发报警
     */
    public Long getBalanceNotifyAmount() {
        return balanceNotifyAmount;
    }

    /**
     * 设置余额报警阀值（厘），余额低于此值时会触发报警
     *
     * @param balanceNotifyAmount 余额报警阀值（厘），余额低于此值时会触发报警
     */
    public void setBalanceNotifyAmount(Long balanceNotifyAmount) {
        this.balanceNotifyAmount = balanceNotifyAmount;
    }

    /**
     * 获取余额报警通知地址，不存在时不通知
     *
     * @return balance_notify_url - 余额报警通知地址，不存在时不通知
     */
    public String getBalanceNotifyUrl() {
        return balanceNotifyUrl;
    }

    /**
     * 设置余额报警通知地址，不存在时不通知
     *
     * @param balanceNotifyUrl 余额报警通知地址，不存在时不通知
     */
    public void setBalanceNotifyUrl(String balanceNotifyUrl) {
        this.balanceNotifyUrl = balanceNotifyUrl;
    }

    /**
     * 获取商户通信请求密钥
     *
     * @return sign_key - 商户通信请求密钥
     */
    public String getSignKey() {
        return signKey;
    }

    /**
     * 设置商户通信请求密钥
     *
     * @param signKey 商户通信请求密钥
     */
    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    /**
     * 获取允许通知:0不允许；1允许
     *
     * @return allow_notify - 允许通知:0不允许；1允许
     */
    public Integer getAllowNotify() {
        return allowNotify;
    }

    /**
     * 设置允许通知:0不允许；1允许
     *
     * @param allowNotify 允许通知:0不允许；1允许
     */
    public void setAllowNotify(Integer allowNotify) {
        this.allowNotify = allowNotify;
    }

    /**
     * @return company_comments
     */
    public String getCompanyComments() {
        return companyComments;
    }

    /**
     * @param companyComments
     */
    public void setCompanyComments(String companyComments) {
        this.companyComments = companyComments;
    }
}