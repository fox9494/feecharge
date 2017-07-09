package com.business.api.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum OrderStatus {

    //订单取消
    CANCLE(-1),
    //待处理
    READY(0),
    //充值中
    PROCESSING(1);


    private Integer value;

    OrderStatus(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
