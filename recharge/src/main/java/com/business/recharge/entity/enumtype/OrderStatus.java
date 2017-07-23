package com.business.recharge.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum OrderStatus {

    //订单取消
    CANCLE(-1),
    //待处理
    READY(0),
    //成功
    SUCCESS(1),
    //失败
    FAIL(2),
    //充值中
    PROCESSING(3);


    private Integer value;

    OrderStatus(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
