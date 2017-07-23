package com.business.recharge.entity.enumtype;

/**
 * Created by chenll on 2017/7/5.
 *业务类型枚举类
 */
public enum BusinessType {

    //Q币
    QICON(10),
    //流量
    DATAFLOW(11),
    //话费
    CALLFEE(12),
    //游戏
    GAME(13);

    private Integer value;

    BusinessType(Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }
}
