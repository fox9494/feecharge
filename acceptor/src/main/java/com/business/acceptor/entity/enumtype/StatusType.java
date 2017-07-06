package com.business.acceptor.entity.enumtype;

/**
 * Created by chenll on 2017/7/5.
 *
 * 通用状态枚举
 */
public enum StatusType {

    //无效
    INVALID(0),
    //正常
    NORMAL(1);

    private Integer value;

    StatusType(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
