package com.business.api.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "qcoin_order")
public class QcoinOrder extends BaseEntity{

    /**
     * 系统订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商户订单号
     */
    @Column(name = "mer_order_no")
    private String merOrderNo;

    /**
     * 商户账号
     */
    @Column(name = "mer_account")
    private String merAccount;

    /**
     * QQ账号
     */
    @Column(name = "recharge_account")
    private String rechargeAccount;

    /**
     * 充值面值，Q币默认是100(1元)
     */
    @Column(name = "recharge_value")
    private Long rechargeValue;

    /**
     * 充值数量，默认是1
     */
    @Column(name = "recharge_num")
    private Long rechargeNum;

    /**
     * 订单涉及金额(厘）
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 商户支付金额(厘）
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 商户折扣金额(厘）
     */
    @Column(name = "discount_amount")
    private Long discountAmount;

    /**
     * 成功到账金额(厘）
     */
    @Column(name = "success_amount")
    private Long successAmount;

    /**
     * 订单详细:Q币充值10元
     */
    @Column(name = "order_detail")
    private String orderDetail;

    /**
     * 订单状态，见订单状态字典表
     */
    @Column(name = "order_state")
    private Integer orderState;

    /**
     * 订单业务入库时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 充值省份区号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 充值IP地址地址
     */
    @Column(name = "customer_ip")
    private String customerIp;

    /**
     * 处理状态：0未开始处理，1正在处理中；2处理完成
     */
    @Column(name = "handle_state")
    private Integer handleState;

    /**
     * 开始处理时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 是否允许拆单:0不允许；1允许
     */
    @Column(name = "allow_split")
    private Integer allowSplit;

    /**
     * 是否允许延迟到账：0不允许；1允许
     */
    @Column(name = "allow_delay")
    private Integer allowDelay;

    /**
     * 匹配状态:0未匹配；1匹配成功；2匹配失败
     */
    @Column(name = "match_state")
    private Integer matchState;

    /**
     * QQ碰撞省份
     */
    @Column(name = "match_province_code")
    private String matchProvinceCode;

    /**
     * 返佣折扣率
     */
    @Column(name = "discount_rate")
    private Double discountRate;

    /**
     * 折扣省份编码
     */
    @Column(name = "discount_province_code")
    private String discountProvinceCode;


    /**
     * 获取系统订单号
     *
     * @return order_no - 系统订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置系统订单号
     *
     * @param orderNo 系统订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * 获取QQ账号
     *
     * @return recharge_account - QQ账号
     */
    public String getRechargeAccount() {
        return rechargeAccount;
    }

    /**
     * 设置QQ账号
     *
     * @param rechargeAccount QQ账号
     */
    public void setRechargeAccount(String rechargeAccount) {
        this.rechargeAccount = rechargeAccount;
    }

    /**
     * 获取充值面值，Q币默认是100(1元)
     *
     * @return recharge_value - 充值面值，Q币默认是100(1元)
     */
    public Long getRechargeValue() {
        return rechargeValue;
    }

    /**
     * 设置充值面值，Q币默认是100(1元)
     *
     * @param rechargeValue 充值面值，Q币默认是100(1元)
     */
    public void setRechargeValue(Long rechargeValue) {
        this.rechargeValue = rechargeValue;
    }

    /**
     * 获取充值数量，默认是1
     *
     * @return recharge_num - 充值数量，默认是1
     */
    public Long getRechargeNum() {
        return rechargeNum;
    }

    /**
     * 设置充值数量，默认是1
     *
     * @param rechargeNum 充值数量，默认是1
     */
    public void setRechargeNum(Long rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    /**
     * 获取订单涉及金额(厘）
     *
     * @return order_amount - 订单涉及金额(厘）
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单涉及金额(厘）
     *
     * @param orderAmount 订单涉及金额(厘）
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取商户支付金额(厘）
     *
     * @return pay_amount - 商户支付金额(厘）
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置商户支付金额(厘）
     *
     * @param payAmount 商户支付金额(厘）
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取商户折扣金额(厘）
     *
     * @return discount_amount - 商户折扣金额(厘）
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 设置商户折扣金额(厘）
     *
     * @param discountAmount 商户折扣金额(厘）
     */
    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 获取成功到账金额(厘）
     *
     * @return success_amount - 成功到账金额(厘）
     */
    public Long getSuccessAmount() {
        return successAmount;
    }

    /**
     * 设置成功到账金额(厘）
     *
     * @param successAmount 成功到账金额(厘）
     */
    public void setSuccessAmount(Long successAmount) {
        this.successAmount = successAmount;
    }

    /**
     * 获取订单详细:Q币充值10元
     *
     * @return order_detail - 订单详细:Q币充值10元
     */
    public String getOrderDetail() {
        return orderDetail;
    }

    /**
     * 设置订单详细:Q币充值10元
     *
     * @param orderDetail 订单详细:Q币充值10元
     */
    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     * 获取订单状态，见订单状态字典表
     *
     * @return order_state - 订单状态，见订单状态字典表
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * 设置订单状态，见订单状态字典表
     *
     * @param orderState 订单状态，见订单状态字典表
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取订单业务入库时间
     *
     * @return order_time - 订单业务入库时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置订单业务入库时间
     *
     * @param orderTime 订单业务入库时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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
     * 获取充值IP地址地址
     *
     * @return customer_ip - 充值IP地址地址
     */
    public String getCustomerIp() {
        return customerIp;
    }

    /**
     * 设置充值IP地址地址
     *
     * @param customerIp 充值IP地址地址
     */
    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    /**
     * 获取处理状态：0未开始处理，1正在处理中；2处理完成
     *
     * @return handle_state - 处理状态：0未开始处理，1正在处理中；2处理完成
     */
    public Integer getHandleState() {
        return handleState;
    }

    /**
     * 设置处理状态：0未开始处理，1正在处理中；2处理完成
     *
     * @param handleState 处理状态：0未开始处理，1正在处理中；2处理完成
     */
    public void setHandleState(Integer handleState) {
        this.handleState = handleState;
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
     * 获取是否允许拆单:0不允许；1允许
     *
     * @return allow_split - 是否允许拆单:0不允许；1允许
     */
    public Integer getAllowSplit() {
        return allowSplit;
    }

    /**
     * 设置是否允许拆单:0不允许；1允许
     *
     * @param allowSplit 是否允许拆单:0不允许；1允许
     */
    public void setAllowSplit(Integer allowSplit) {
        this.allowSplit = allowSplit;
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
     * 获取匹配状态:0未匹配；1匹配成功；2匹配失败
     *
     * @return match_state - 匹配状态:0未匹配；1匹配成功；2匹配失败
     */
    public Integer getMatchState() {
        return matchState;
    }

    /**
     * 设置匹配状态:0未匹配；1匹配成功；2匹配失败
     *
     * @param matchState 匹配状态:0未匹配；1匹配成功；2匹配失败
     */
    public void setMatchState(Integer matchState) {
        this.matchState = matchState;
    }

    /**
     * 获取QQ碰撞省份
     *
     * @return match_province_code - QQ碰撞省份
     */
    public String getMatchProvinceCode() {
        return matchProvinceCode;
    }

    /**
     * 设置QQ碰撞省份
     *
     * @param matchProvinceCode QQ碰撞省份
     */
    public void setMatchProvinceCode(String matchProvinceCode) {
        this.matchProvinceCode = matchProvinceCode;
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
     * 获取折扣省份编码
     *
     * @return discount_province_code - 折扣省份编码
     */
    public String getDiscountProvinceCode() {
        return discountProvinceCode;
    }

    /**
     * 设置折扣省份编码
     *
     * @param discountProvinceCode 折扣省份编码
     */
    public void setDiscountProvinceCode(String discountProvinceCode) {
        this.discountProvinceCode = discountProvinceCode;
    }
}