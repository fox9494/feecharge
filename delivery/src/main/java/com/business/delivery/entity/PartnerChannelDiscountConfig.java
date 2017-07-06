package com.business.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "partner_channel_discount_config")
public class PartnerChannelDiscountConfig extends BaseEntity{

    /**
     * 业务类型
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 渠道Id号
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 省份区号
     */
    @Column(name = "province_code")
    private String provinceCode;

    /**
     * 当前渠道该省份的折扣率,97则填入0.97
     */
    @Column(name = "discount_rate")
    private Double discountRate;

    /**
     * 上游产品对应的编号
     */
    @Column(name = "product_info")
    private String productInfo;

    /**
     * 配置是否有效:1有效;0无效
     */
    private Integer state;


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
     * 获取渠道Id号
     *
     * @return channel_id - 渠道Id号
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道Id号
     *
     * @param channelId 渠道Id号
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取省份区号
     *
     * @return province_code - 省份区号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省份区号
     *
     * @param provinceCode 省份区号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取当前渠道该省份的折扣率,97则填入0.97
     *
     * @return discount_rate - 当前渠道该省份的折扣率,97则填入0.97
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * 设置当前渠道该省份的折扣率,97则填入0.97
     *
     * @param discountRate 当前渠道该省份的折扣率,97则填入0.97
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * 获取上游产品对应的编号
     *
     * @return product_info - 上游产品对应的编号
     */
    public String getProductInfo() {
        return productInfo;
    }

    /**
     * 设置上游产品对应的编号
     *
     * @param productInfo 上游产品对应的编号
     */
    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    /**
     * 获取配置是否有效:1有效;0无效
     *
     * @return state - 配置是否有效:1有效;0无效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置配置是否有效:1有效;0无效
     *
     * @param state 配置是否有效:1有效;0无效
     */
    public void setState(Integer state) {
        this.state = state;
    }
}