package com.business.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "partner_channel")
public class PartnerChannel extends BaseEntity{

    /**
     * 渠道编号，插入时自增
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 业务编号
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 渠道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 权重信息
     */
    private Integer weight;

    /**
     * 支持省份区号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 状态：0无效；1有效
     */
    private Integer state;

    /**
     * 查询状态:0不支持查询；1支持查询
     */
    @Column(name = "query_state")
    private Integer queryState;

    /**
     * 首次查单间隔(毫秒)，只在下单后第一次查单时有效，默认是30秒
     */
    @Column(name = "first_query_interval")
    private Long firstQueryInterval;

    /**
     * 再查查单间隔(毫秒)，除了首次查询之后的时间间隔，默认30秒
     */
    @Column(name = "retry_query_interval")
    private Long retryQueryInterval;

    /**
     * 最大查询时间(毫秒)，默认是30分钟
     */
    @Column(name = "max_query_time")
    private Long maxQueryTime;

    /**
     * 针对运营商接口执行完一次后需要睡眠的时间(毫秒)
     */
    @Column(name = "sleep_time")
    private Long sleepTime;

    /**
     * 渠道提供给我们方的商户账号
     */
    @Column(name = "channel_mer_account")
    private String channelMerAccount;

    /**
     * 验证是否通过:0未通过；1已通过
     */
    private Integer verified;

    /**
     * 备注
     */
    private String remark;


    /**
     * 获取渠道编号，插入时自增
     *
     * @return channel_id - 渠道编号，插入时自增
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道编号，插入时自增
     *
     * @param channelId 渠道编号，插入时自增
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取业务编号
     *
     * @return business_type - 业务编号
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务编号
     *
     * @param businessType 业务编号
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取渠道名称
     *
     * @return channel_name - 渠道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置渠道名称
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取权重信息
     *
     * @return weight - 权重信息
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重信息
     *
     * @param weight 权重信息
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取支持省份区号
     *
     * @return province_code - 支持省份区号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置支持省份区号
     *
     * @param provinceCode 支持省份区号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取状态：0无效；1有效
     *
     * @return state - 状态：0无效；1有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态：0无效；1有效
     *
     * @param state 状态：0无效；1有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取查询状态:0不支持查询；1支持查询
     *
     * @return query_state - 查询状态:0不支持查询；1支持查询
     */
    public Integer getQueryState() {
        return queryState;
    }

    /**
     * 设置查询状态:0不支持查询；1支持查询
     *
     * @param queryState 查询状态:0不支持查询；1支持查询
     */
    public void setQueryState(Integer queryState) {
        this.queryState = queryState;
    }

    /**
     * 获取首次查单间隔(毫秒)，只在下单后第一次查单时有效，默认是30秒
     *
     * @return first_query_interval - 首次查单间隔(毫秒)，只在下单后第一次查单时有效，默认是30秒
     */
    public Long getFirstQueryInterval() {
        return firstQueryInterval;
    }

    /**
     * 设置首次查单间隔(毫秒)，只在下单后第一次查单时有效，默认是30秒
     *
     * @param firstQueryInterval 首次查单间隔(毫秒)，只在下单后第一次查单时有效，默认是30秒
     */
    public void setFirstQueryInterval(Long firstQueryInterval) {
        this.firstQueryInterval = firstQueryInterval;
    }

    /**
     * 获取再查查单间隔(毫秒)，除了首次查询之后的时间间隔，默认30秒
     *
     * @return retry_query_interval - 再查查单间隔(毫秒)，除了首次查询之后的时间间隔，默认30秒
     */
    public Long getRetryQueryInterval() {
        return retryQueryInterval;
    }

    /**
     * 设置再查查单间隔(毫秒)，除了首次查询之后的时间间隔，默认30秒
     *
     * @param retryQueryInterval 再查查单间隔(毫秒)，除了首次查询之后的时间间隔，默认30秒
     */
    public void setRetryQueryInterval(Long retryQueryInterval) {
        this.retryQueryInterval = retryQueryInterval;
    }

    /**
     * 获取最大查询时间(毫秒)，默认是30分钟
     *
     * @return max_query_time - 最大查询时间(毫秒)，默认是30分钟
     */
    public Long getMaxQueryTime() {
        return maxQueryTime;
    }

    /**
     * 设置最大查询时间(毫秒)，默认是30分钟
     *
     * @param maxQueryTime 最大查询时间(毫秒)，默认是30分钟
     */
    public void setMaxQueryTime(Long maxQueryTime) {
        this.maxQueryTime = maxQueryTime;
    }

    /**
     * 获取针对运营商接口执行完一次后需要睡眠的时间(毫秒)
     *
     * @return sleep_time - 针对运营商接口执行完一次后需要睡眠的时间(毫秒)
     */
    public Long getSleepTime() {
        return sleepTime;
    }

    /**
     * 设置针对运营商接口执行完一次后需要睡眠的时间(毫秒)
     *
     * @param sleepTime 针对运营商接口执行完一次后需要睡眠的时间(毫秒)
     */
    public void setSleepTime(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    /**
     * 获取渠道提供给我们方的商户账号
     *
     * @return channel_mer_account - 渠道提供给我们方的商户账号
     */
    public String getChannelMerAccount() {
        return channelMerAccount;
    }

    /**
     * 设置渠道提供给我们方的商户账号
     *
     * @param channelMerAccount 渠道提供给我们方的商户账号
     */
    public void setChannelMerAccount(String channelMerAccount) {
        this.channelMerAccount = channelMerAccount;
    }

    /**
     * 获取验证是否通过:0未通过；1已通过
     *
     * @return verified - 验证是否通过:0未通过；1已通过
     */
    public Integer getVerified() {
        return verified;
    }

    /**
     * 设置验证是否通过:0未通过；1已通过
     *
     * @param verified 验证是否通过:0未通过；1已通过
     */
    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}