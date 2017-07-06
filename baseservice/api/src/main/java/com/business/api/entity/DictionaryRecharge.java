package com.business.api.entity;

import javax.persistence.Table;

@Table(name = "dictionary_recharge")
public class DictionaryRecharge extends BaseEntity{

    private String type;

    private String name;

    private Integer value;


    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}