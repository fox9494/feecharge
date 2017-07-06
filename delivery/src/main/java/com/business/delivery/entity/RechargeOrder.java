package com.business.delivery.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "recharge_order")
public class RechargeOrder implements Serializable{
    /**
     * 自增主键，无意义
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单业务类型，见业务类型字典表
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 商户订单号，请保持唯一
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 商户编号
     */
    @Column(name = "merchant_account")
    private String merchantAccount;

    /**
     * 扩展账号，主要针对部分商户的定制需求
     */
    @Column(name = "extend_account")
    private String extendAccount;

    /**
     * 充值账号,主要是直接相关联的账号
     */
    @Column(name = "recharge_account")
    private String rechargeAccount;

    /**
     * 充值面值
     */
    @Column(name = "recharge_value")
    private Long rechargeValue;

    /**
     * 充值数量
     */
    @Column(name = "recharge_num")
    private Long rechargeNum;

    /**
     * 商户订单时间，用于判断时间是否过期
     */
    @Column(name = "merchant_order_time")
    private Date merchantOrderTime;

    /**
     * 系统接单时间，订单入库时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 订单涉及金额(厘）
     */
    @Column(name = "order_amount")
    private Long orderAmount;

    /**
     * 订单应付金额(厘）
     */
    @Column(name = "pay_amount")
    private Long payAmount;

    /**
     * 折扣价格(厘），最后实际支付的金额
     */
    @Column(name = "discount_amount")
    private Long discountAmount;

    /**
     * 成功到账金额(厘）,当到账金额与订单金额不一致时将触发退款
     */
    @Column(name = "success_amount")
    private Long successAmount;

    /**
     * 扩展参数,主要用于部分需要扩展的参数传值，Json格式
     */
    @Column(name = "extend_param")
    private String extendParam;

    /**
     * 业务系统响应数据
     */
    @Column(name = "business_attach")
    private String businessAttach;

    /**
     * 订单详细描述，比如：Q币充值10元
     */
    @Column(name = "order_detail")
    private String orderDetail;

    /**
     * 支付状态，见pay_state_dictionary
     */
    @Column(name = "pay_state")
    private Integer payState;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 订单状态，见order_state_dictionary，默认是0初始化等待处理
     */
    @Column(name = "order_state")
    private Integer orderState;

    /**
     * 退款金额(厘）
     */
    @Column(name = "refund_amount")
    private Long refundAmount;

    /**
     * 退款状态：见refund_state_dictionary，默认是0未退款
     */
    @Column(name = "refund_state")
    private Integer refundState;

    /**
     * 退款时间
     */
    @Column(name = "refund_time")
    private Date refundTime;

    /**
     * 返佣类型：0前返；1后返
     */
    @Column(name = "rebate_type")
    private Integer rebateType;

    /**
     * 返佣金额(厘）
     */
    @Column(name = "rebate_amount")
    private Long rebateAmount;

    /**
     * 返佣状态，默认是0返佣
     */
    @Column(name = "rebate_state")
    private Byte rebateState;

    /**
     * 返佣时间
     */
    @Column(name = "rebate_time")
    private Date rebateTime;

    /**
     * 下单用户IP地址
     */
    @Column(name = "customer_ip")
    private String customerIp;

    /**
     * 商户下单IP
     */
    @Column(name = "merchant_ip")
    private String merchantIp;

    /**
     * 商户通知地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 商户下单时的备注信息，将原样回掉给商户
     */
    private String attach;

    /**
     * 来源平台
     */
    @Column(name = "src_platform")
    private String srcPlatform;

    /**
     * 通知次数
     */
    @Column(name = "notify_times")
    private Integer notifyTimes;

    /**
     * 通知间隔(秒)，默认是30秒；1分钟；3分钟
     */
    @Column(name = "notify_interval")
    private String notifyInterval;

    /**
     * 首次通知时间
     */
    @Column(name = "notify_first_time")
    private Date notifyFirstTime;

    /**
     * 最近一次通知时间
     */
    @Column(name = "notify_latest_time")
    private Date notifyLatestTime;

    /**
     * 通知状态：0未通知；1通知成功；2通知失败
     */
    @Column(name = "notify_state")
    private Integer notifyState;

    /**
     * 处理结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 冲正结果通知地址
     */
    @Column(name = "correct_notify_url")
    private String correctNotifyUrl;

    /**
     * 冲正状态
     */
    @Column(name = "correct_state")
    private Integer correctState;

    /**
     * 成功冲正金额
     */
    @Column(name = "correct_amount")
    private Long correctAmount;

    /**
     * 请求冲正时间
     */
    @Column(name = "correct_time")
    private Date correctTime;

    /**
     * 冲正结束时间
     */
    @Column(name = "correct_end_time")
    private Date correctEndTime;

    /**
     * 返佣城市编码
     */
    @Column(name = "discount_province_code")
    private String discountProvinceCode;

    /**
     * 折扣价
     */
    @Column(name = "discount_rate")
    private Double discountRate;

    /**
     * 获取自增主键，无意义
     *
     * @return id - 自增主键，无意义
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增主键，无意义
     *
     * @param id 自增主键，无意义
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * 获取订单业务类型，见业务类型字典表
     *
     * @return business_type - 订单业务类型，见业务类型字典表
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置订单业务类型，见业务类型字典表
     *
     * @param businessType 订单业务类型，见业务类型字典表
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取商户订单号，请保持唯一
     *
     * @return merchant_order_no - 商户订单号，请保持唯一
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置商户订单号，请保持唯一
     *
     * @param merchantOrderNo 商户订单号，请保持唯一
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    /**
     * 获取商户编号
     *
     * @return merchant_account - 商户编号
     */
    public String getMerchantAccount() {
        return merchantAccount;
    }

    /**
     * 设置商户编号
     *
     * @param merchantAccount 商户编号
     */
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    /**
     * 获取扩展账号，主要针对部分商户的定制需求
     *
     * @return extend_account - 扩展账号，主要针对部分商户的定制需求
     */
    public String getExtendAccount() {
        return extendAccount;
    }

    /**
     * 设置扩展账号，主要针对部分商户的定制需求
     *
     * @param extendAccount 扩展账号，主要针对部分商户的定制需求
     */
    public void setExtendAccount(String extendAccount) {
        this.extendAccount = extendAccount;
    }

    /**
     * 获取充值账号,主要是直接相关联的账号
     *
     * @return recharge_account - 充值账号,主要是直接相关联的账号
     */
    public String getRechargeAccount() {
        return rechargeAccount;
    }

    /**
     * 设置充值账号,主要是直接相关联的账号
     *
     * @param rechargeAccount 充值账号,主要是直接相关联的账号
     */
    public void setRechargeAccount(String rechargeAccount) {
        this.rechargeAccount = rechargeAccount;
    }

    /**
     * 获取充值面值
     *
     * @return recharge_value - 充值面值
     */
    public Long getRechargeValue() {
        return rechargeValue;
    }

    /**
     * 设置充值面值
     *
     * @param rechargeValue 充值面值
     */
    public void setRechargeValue(Long rechargeValue) {
        this.rechargeValue = rechargeValue;
    }

    /**
     * 获取充值数量
     *
     * @return recharge_num - 充值数量
     */
    public Long getRechargeNum() {
        return rechargeNum;
    }

    /**
     * 设置充值数量
     *
     * @param rechargeNum 充值数量
     */
    public void setRechargeNum(Long rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    /**
     * 获取商户订单时间，用于判断时间是否过期
     *
     * @return merchant_order_time - 商户订单时间，用于判断时间是否过期
     */
    public Date getMerchantOrderTime() {
        return merchantOrderTime;
    }

    /**
     * 设置商户订单时间，用于判断时间是否过期
     *
     * @param merchantOrderTime 商户订单时间，用于判断时间是否过期
     */
    public void setMerchantOrderTime(Date merchantOrderTime) {
        this.merchantOrderTime = merchantOrderTime;
    }

    /**
     * 获取系统接单时间，订单入库时间
     *
     * @return order_time - 系统接单时间，订单入库时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置系统接单时间，订单入库时间
     *
     * @param orderTime 系统接单时间，订单入库时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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
     * 获取订单应付金额(厘）
     *
     * @return pay_amount - 订单应付金额(厘）
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 设置订单应付金额(厘）
     *
     * @param payAmount 订单应付金额(厘）
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取折扣价格(厘），最后实际支付的金额
     *
     * @return discount_amount - 折扣价格(厘），最后实际支付的金额
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * 设置折扣价格(厘），最后实际支付的金额
     *
     * @param discountAmount 折扣价格(厘），最后实际支付的金额
     */
    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * 获取成功到账金额(厘）,当到账金额与订单金额不一致时将触发退款
     *
     * @return success_amount - 成功到账金额(厘）,当到账金额与订单金额不一致时将触发退款
     */
    public Long getSuccessAmount() {
        return successAmount;
    }

    /**
     * 设置成功到账金额(厘）,当到账金额与订单金额不一致时将触发退款
     *
     * @param successAmount 成功到账金额(厘）,当到账金额与订单金额不一致时将触发退款
     */
    public void setSuccessAmount(Long successAmount) {
        this.successAmount = successAmount;
    }

    /**
     * 获取扩展参数,主要用于部分需要扩展的参数传值，Json格式
     *
     * @return extend_param - 扩展参数,主要用于部分需要扩展的参数传值，Json格式
     */
    public String getExtendParam() {
        return extendParam;
    }

    /**
     * 设置扩展参数,主要用于部分需要扩展的参数传值，Json格式
     *
     * @param extendParam 扩展参数,主要用于部分需要扩展的参数传值，Json格式
     */
    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }

    /**
     * 获取业务系统响应数据
     *
     * @return business_attach - 业务系统响应数据
     */
    public String getBusinessAttach() {
        return businessAttach;
    }

    /**
     * 设置业务系统响应数据
     *
     * @param businessAttach 业务系统响应数据
     */
    public void setBusinessAttach(String businessAttach) {
        this.businessAttach = businessAttach;
    }

    /**
     * 获取订单详细描述，比如：Q币充值10元
     *
     * @return order_detail - 订单详细描述，比如：Q币充值10元
     */
    public String getOrderDetail() {
        return orderDetail;
    }

    /**
     * 设置订单详细描述，比如：Q币充值10元
     *
     * @param orderDetail 订单详细描述，比如：Q币充值10元
     */
    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     * 获取支付状态，见pay_state_dictionary
     *
     * @return pay_state - 支付状态，见pay_state_dictionary
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 设置支付状态，见pay_state_dictionary
     *
     * @param payState 支付状态，见pay_state_dictionary
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取订单状态，见order_state_dictionary，默认是0初始化等待处理
     *
     * @return order_state - 订单状态，见order_state_dictionary，默认是0初始化等待处理
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * 设置订单状态，见order_state_dictionary，默认是0初始化等待处理
     *
     * @param orderState 订单状态，见order_state_dictionary，默认是0初始化等待处理
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取退款金额(厘）
     *
     * @return refund_amount - 退款金额(厘）
     */
    public Long getRefundAmount() {
        return refundAmount;
    }

    /**
     * 设置退款金额(厘）
     *
     * @param refundAmount 退款金额(厘）
     */
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 获取退款状态：见refund_state_dictionary，默认是0未退款
     *
     * @return refund_state - 退款状态：见refund_state_dictionary，默认是0未退款
     */
    public Integer getRefundState() {
        return refundState;
    }

    /**
     * 设置退款状态：见refund_state_dictionary，默认是0未退款
     *
     * @param refundState 退款状态：见refund_state_dictionary，默认是0未退款
     */
    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    /**
     * 获取退款时间
     *
     * @return refund_time - 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * 设置退款时间
     *
     * @param refundTime 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 获取返佣类型：0前返；1后返
     *
     * @return rebate_type - 返佣类型：0前返；1后返
     */
    public Integer getRebateType() {
        return rebateType;
    }

    /**
     * 设置返佣类型：0前返；1后返
     *
     * @param rebateType 返佣类型：0前返；1后返
     */
    public void setRebateType(Integer rebateType) {
        this.rebateType = rebateType;
    }

    /**
     * 获取返佣金额(厘）
     *
     * @return rebate_amount - 返佣金额(厘）
     */
    public Long getRebateAmount() {
        return rebateAmount;
    }

    /**
     * 设置返佣金额(厘）
     *
     * @param rebateAmount 返佣金额(厘）
     */
    public void setRebateAmount(Long rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    /**
     * 获取返佣状态，默认是0返佣
     *
     * @return rebate_state - 返佣状态，默认是0返佣
     */
    public Byte getRebateState() {
        return rebateState;
    }

    /**
     * 设置返佣状态，默认是0返佣
     *
     * @param rebateState 返佣状态，默认是0返佣
     */
    public void setRebateState(Byte rebateState) {
        this.rebateState = rebateState;
    }

    /**
     * 获取返佣时间
     *
     * @return rebate_time - 返佣时间
     */
    public Date getRebateTime() {
        return rebateTime;
    }

    /**
     * 设置返佣时间
     *
     * @param rebateTime 返佣时间
     */
    public void setRebateTime(Date rebateTime) {
        this.rebateTime = rebateTime;
    }

    /**
     * 获取下单用户IP地址
     *
     * @return customer_ip - 下单用户IP地址
     */
    public String getCustomerIp() {
        return customerIp;
    }

    /**
     * 设置下单用户IP地址
     *
     * @param customerIp 下单用户IP地址
     */
    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    /**
     * 获取商户下单IP
     *
     * @return merchant_ip - 商户下单IP
     */
    public String getMerchantIp() {
        return merchantIp;
    }

    /**
     * 设置商户下单IP
     *
     * @param merchantIp 商户下单IP
     */
    public void setMerchantIp(String merchantIp) {
        this.merchantIp = merchantIp;
    }

    /**
     * 获取商户通知地址
     *
     * @return notify_url - 商户通知地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置商户通知地址
     *
     * @param notifyUrl 商户通知地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * 获取商户下单时的备注信息，将原样回掉给商户
     *
     * @return attach - 商户下单时的备注信息，将原样回掉给商户
     */
    public String getAttach() {
        return attach;
    }

    /**
     * 设置商户下单时的备注信息，将原样回掉给商户
     *
     * @param attach 商户下单时的备注信息，将原样回掉给商户
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * 获取来源平台
     *
     * @return src_platform - 来源平台
     */
    public String getSrcPlatform() {
        return srcPlatform;
    }

    /**
     * 设置来源平台
     *
     * @param srcPlatform 来源平台
     */
    public void setSrcPlatform(String srcPlatform) {
        this.srcPlatform = srcPlatform;
    }

    /**
     * 获取通知次数
     *
     * @return notify_times - 通知次数
     */
    public Integer getNotifyTimes() {
        return notifyTimes;
    }

    /**
     * 设置通知次数
     *
     * @param notifyTimes 通知次数
     */
    public void setNotifyTimes(Integer notifyTimes) {
        this.notifyTimes = notifyTimes;
    }

    /**
     * 获取通知间隔(秒)，默认是30秒；1分钟；3分钟
     *
     * @return notify_interval - 通知间隔(秒)，默认是30秒；1分钟；3分钟
     */
    public String getNotifyInterval() {
        return notifyInterval;
    }

    /**
     * 设置通知间隔(秒)，默认是30秒；1分钟；3分钟
     *
     * @param notifyInterval 通知间隔(秒)，默认是30秒；1分钟；3分钟
     */
    public void setNotifyInterval(String notifyInterval) {
        this.notifyInterval = notifyInterval;
    }

    /**
     * 获取首次通知时间
     *
     * @return notify_first_time - 首次通知时间
     */
    public Date getNotifyFirstTime() {
        return notifyFirstTime;
    }

    /**
     * 设置首次通知时间
     *
     * @param notifyFirstTime 首次通知时间
     */
    public void setNotifyFirstTime(Date notifyFirstTime) {
        this.notifyFirstTime = notifyFirstTime;
    }

    /**
     * 获取最近一次通知时间
     *
     * @return notify_latest_time - 最近一次通知时间
     */
    public Date getNotifyLatestTime() {
        return notifyLatestTime;
    }

    /**
     * 设置最近一次通知时间
     *
     * @param notifyLatestTime 最近一次通知时间
     */
    public void setNotifyLatestTime(Date notifyLatestTime) {
        this.notifyLatestTime = notifyLatestTime;
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
     * 获取处理结束时间
     *
     * @return end_time - 处理结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置处理结束时间
     *
     * @param endTime 处理结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取冲正结果通知地址
     *
     * @return correct_notify_url - 冲正结果通知地址
     */
    public String getCorrectNotifyUrl() {
        return correctNotifyUrl;
    }

    /**
     * 设置冲正结果通知地址
     *
     * @param correctNotifyUrl 冲正结果通知地址
     */
    public void setCorrectNotifyUrl(String correctNotifyUrl) {
        this.correctNotifyUrl = correctNotifyUrl;
    }

    /**
     * 获取冲正状态
     *
     * @return correct_state - 冲正状态
     */
    public Integer getCorrectState() {
        return correctState;
    }

    /**
     * 设置冲正状态
     *
     * @param correctState 冲正状态
     */
    public void setCorrectState(Integer correctState) {
        this.correctState = correctState;
    }

    /**
     * 获取成功冲正金额
     *
     * @return correct_amount - 成功冲正金额
     */
    public Long getCorrectAmount() {
        return correctAmount;
    }

    /**
     * 设置成功冲正金额
     *
     * @param correctAmount 成功冲正金额
     */
    public void setCorrectAmount(Long correctAmount) {
        this.correctAmount = correctAmount;
    }

    /**
     * 获取请求冲正时间
     *
     * @return correct_time - 请求冲正时间
     */
    public Date getCorrectTime() {
        return correctTime;
    }

    /**
     * 设置请求冲正时间
     *
     * @param correctTime 请求冲正时间
     */
    public void setCorrectTime(Date correctTime) {
        this.correctTime = correctTime;
    }

    /**
     * 获取冲正结束时间
     *
     * @return correct_end_time - 冲正结束时间
     */
    public Date getCorrectEndTime() {
        return correctEndTime;
    }

    /**
     * 设置冲正结束时间
     *
     * @param correctEndTime 冲正结束时间
     */
    public void setCorrectEndTime(Date correctEndTime) {
        this.correctEndTime = correctEndTime;
    }

    /**
     * 获取返佣城市编码
     *
     * @return discount_province_code - 返佣城市编码
     */
    public String getDiscountProvinceCode() {
        return discountProvinceCode;
    }

    /**
     * 设置返佣城市编码
     *
     * @param discountProvinceCode 返佣城市编码
     */
    public void setDiscountProvinceCode(String discountProvinceCode) {
        this.discountProvinceCode = discountProvinceCode;
    }

    /**
     * 获取折扣价
     *
     * @return discount_rate - 折扣价
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置折扣价
     *
     * @param discountRate 折扣价
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}