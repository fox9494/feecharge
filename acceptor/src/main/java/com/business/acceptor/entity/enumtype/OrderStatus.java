package com.business.acceptor.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum OrderStatus {

    SUCCESS("1"),
    FAIL("0");

    private String value;

    OrderStatus(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
