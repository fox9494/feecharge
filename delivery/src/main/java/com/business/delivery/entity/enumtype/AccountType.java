package com.business.delivery.entity.enumtype;

/**
 * Created by chenll on 2017/6/23.
 */
public enum AccountType {

    //账户余额
    ACCOUNTMONEY(0),
    //返佣账户
    COMMISSION(1);

    private Integer value;

    AccountType(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
