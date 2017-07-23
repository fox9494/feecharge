package com.business.recharge.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum AccountStatus {

    //冻结
    FROZEN(0),
    //正常
    NORMAL(1);

    private Integer value;

    AccountStatus(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
