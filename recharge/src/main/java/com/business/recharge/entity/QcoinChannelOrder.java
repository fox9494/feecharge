package com.business.recharge.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "qcoin_channel_order")
public class QcoinChannelOrder extends BaseEntity{

    /**
     * 渠道订单号
     */
    @Column(name = "channel_order_no")
    private String channelOrderNo;

    /**
     * 接单系统订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商户账号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 商户订单号
     */
    @Column(name = "mer_order_no")
    private String merOrderNo;

    /**
     * 渠道编号
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 上游商户渠道订单,回写生成
     */
    @Column(name = "partner_order_no")
    private String partnerOrderNo;

    /**
     * 入库时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 充值金额(厘）
     */
    @Column(name = "recharge_amount")
    private Long rechargeAmount;

    /**
     * 成功金额(厘）
     */
    @Column(name = "success_amount")
    private Long successAmount;

    /**
     * 充值省份区号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 充值的QQ号码
     */
    private String qq;

    /**
     * 渠道订单中状态
     */
    @Column(name = "order_state")
    private Integer orderState;

    /**
     * 开始处理时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 订单处理结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 上游返回的结果数据
     */
    @Column(name = "channel_result")
    private String channelResult;

    /**
     * 上游状态内容
     */
    @Column(name = "channel_state")
    private String channelState;

    /**
     * 通知状态：0未通知；1通知成功；2通知失败
     */
    @Column(name = "notify_state")
    private Integer notifyState;

    /**
     * 下单用户ip地址
     */
    private String ip;

    /**
     * 是否允许延迟到账：0不允许；1允许
     */
    @Column(name = "allow_delay")
    private Integer allowDelay;

    /**
     * 系统识别出来的QQ归属地IP
     */
    @Column(name = "fixed_ip")
    private String fixedIp;

    /**
     * 上游渠道折扣率
     */
    @Column(name = "discount_rate")
    private Double discountRate;


    /**
     * 获取渠道订单号
     *
     * @return channel_order_no - 渠道订单号
     */
    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    /**
     * 设置渠道订单号
     *
     * @param channelOrderNo 渠道订单号
     */
    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    /**
     * 获取接单系统订单号
     *
     * @return order_no - 接单系统订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置接单系统订单号
     *
     * @param orderNo 接单系统订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    /**
     * 获取商户订单号
     *
     * @return mer_order_no - 商户订单号
     */
    public String getMerOrderNo() {
        return merOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param merOrderNo 商户订单号
     */
    public void setMerOrderNo(String merOrderNo) {
        this.merOrderNo = merOrderNo;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取上游商户渠道订单,回写生成
     *
     * @return partner_order_no - 上游商户渠道订单,回写生成
     */
    public String getPartnerOrderNo() {
        return partnerOrderNo;
    }

    /**
     * 设置上游商户渠道订单,回写生成
     *
     * @param partnerOrderNo 上游商户渠道订单,回写生成
     */
    public void setPartnerOrderNo(String partnerOrderNo) {
        this.partnerOrderNo = partnerOrderNo;
    }

    /**
     * 获取入库时间
     *
     * @return create_time - 入库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置入库时间
     *
     * @param createTime 入库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取充值金额(厘）
     *
     * @return recharge_amount - 充值金额(厘）
     */
    public Long getRechargeAmount() {
        return rechargeAmount;
    }

    /**
     * 设置充值金额(厘）
     *
     * @param rechargeAmount 充值金额(厘）
     */
    public void setRechargeAmount(Long rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    /**
     * 获取成功金额(厘）
     *
     * @return success_amount - 成功金额(厘）
     */
    public Long getSuccessAmount() {
        return successAmount;
    }

    /**
     * 设置成功金额(厘）
     *
     * @param successAmount 成功金额(厘）
     */
    public void setSuccessAmount(Long successAmount) {
        this.successAmount = successAmount;
    }

    /**
     * 获取充值省份区号
     *
     * @return province_code - 充值省份区号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置充值省份区号
     *
     * @param provinceCode 充值省份区号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取充值的QQ号码
     *
     * @return qq - 充值的QQ号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置充值的QQ号码
     *
     * @param qq 充值的QQ号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取渠道订单中状态
     *
     * @return order_state - 渠道订单中状态
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * 设置渠道订单中状态
     *
     * @param orderState 渠道订单中状态
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取开始处理时间
     *
     * @return handle_time - 开始处理时间
     */
    public Date getHandleTime() {
        return handleTime;
    }

    /**
     * 设置开始处理时间
     *
     * @param handleTime 开始处理时间
     */
    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * 获取订单处理结束时间
     *
     * @return end_time - 订单处理结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置订单处理结束时间
     *
     * @param endTime 订单处理结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取上游返回的结果数据
     *
     * @return channel_result - 上游返回的结果数据
     */
    public String getChannelResult() {
        return channelResult;
    }

    /**
     * 设置上游返回的结果数据
     *
     * @param channelResult 上游返回的结果数据
     */
    public void setChannelResult(String channelResult) {
        this.channelResult = channelResult;
    }

    /**
     * 获取上游状态内容
     *
     * @return channel_state - 上游状态内容
     */
    public String getChannelState() {
        return channelState;
    }

    /**
     * 设置上游状态内容
     *
     * @param channelState 上游状态内容
     */
    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    /**
     * 获取通知状态：0未通知；1通知成功；2通知失败
     *
     * @return notify_state - 通知状态：0未通知；1通知成功；2通知失败
     */
    public Integer getNotifyState() {
        return notifyState;
    }

    /**
     * 设置通知状态：0未通知；1通知成功；2通知失败
     *
     * @param notifyState 通知状态：0未通知；1通知成功；2通知失败
     */
    public void setNotifyState(Integer notifyState) {
        this.notifyState = notifyState;
    }

    /**
     * 获取下单用户ip地址
     *
     * @return ip - 下单用户ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置下单用户ip地址
     *
     * @param ip 下单用户ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取是否允许延迟到账：0不允许；1允许
     *
     * @return allow_delay - 是否允许延迟到账：0不允许；1允许
     */
    public Integer getAllowDelay() {
        return allowDelay;
    }

    /**
     * 设置是否允许延迟到账：0不允许；1允许
     *
     * @param allowDelay 是否允许延迟到账：0不允许；1允许
     */
    public void setAllowDelay(Integer allowDelay) {
        this.allowDelay = allowDelay;
    }

    /**
     * 获取系统识别出来的QQ归属地IP
     *
     * @return fixed_ip - 系统识别出来的QQ归属地IP
     */
    public String getFixedIp() {
        return fixedIp;
    }

    /**
     * 设置系统识别出来的QQ归属地IP
     *
     * @param fixedIp 系统识别出来的QQ归属地IP
     */
    public void setFixedIp(String fixedIp) {
        this.fixedIp = fixedIp;
    }

    /**
     * 获取上游渠道折扣率
     *
     * @return discount_rate - 上游渠道折扣率
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置上游渠道折扣率
     *
     * @param discountRate 上游渠道折扣率
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}