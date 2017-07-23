package com.business.recharge.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ip_address")
public class IpAddress {
    /**
     * ip地址
     */
    @Id
    private String ip;

    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 省份编号
     */
    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "province_name")
    private String provinceName;

    /**
     * 城市编号
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 城市名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 详细地址
     */
    private String location;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return operator_name
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取省份编号
     *
     * @return province_code - 省份编号
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置省份编号
     *
     * @param provinceCode 省份编号
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * @return province_name
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取城市编号
     *
     * @return city_code - 城市编号
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编号
     *
     * @param cityCode 城市编号
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取城市名称
     *
     * @return city_name - 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     *
     * @param cityName 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取详细地址
     *
     * @return location - 详细地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置详细地址
     *
     * @param location 详细地址
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}