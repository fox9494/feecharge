package com.business.api.entity;

import javax.persistence.Table;

@Table(name = "dictionary_business_info")
public class DictionaryBusinessInfo extends BaseEntity{

    /**
     * 业务类型
     */
    private Integer type;

    /**
     * 业务类型名称
     */
    private String name;

    /**
     * 状态：0业务维护；1业务可用
     */
    private Integer state;


    /**
     * 获取业务类型
     *
     * @return type - 业务类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置业务类型
     *
     * @param type 业务类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取业务类型名称
     *
     * @return name - 业务类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置业务类型名称
     *
     * @param name 业务类型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态：0业务维护；1业务可用
     *
     * @return state - 状态：0业务维护；1业务可用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态：0业务维护；1业务可用
     *
     * @param state 状态：0业务维护；1业务可用
     */
    public void setState(Integer state) {
        this.state = state;
    }
}