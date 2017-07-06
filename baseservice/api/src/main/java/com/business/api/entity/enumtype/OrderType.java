package com.business.api.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum OrderType {

    B2C("0"),
    B2B("1");

    private String value;

    OrderType(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
