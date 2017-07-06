package com.business.acceptor.entity;

import javax.persistence.*;

@Table(name = "qcoin_black_list")
public class QcoinBlackList extends BaseEntity {

    /**
     * QQ号码
     */
    @Column(name = "qq_number")
    private String qqNumber;

    /**
     * 状态：0无效；1有效
     */
    private Byte state;


    /**
     * 获取QQ号码
     *
     * @return qq_number - QQ号码
     */
    public String getQqNumber() {
        return qqNumber;
    }

    /**
     * 设置QQ号码
     *
     * @param qqNumber QQ号码
     */
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    /**
     * 获取状态：0无效；1有效
     *
     * @return state - 状态：0无效；1有效
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置状态：0无效；1有效
     *
     * @param state 状态：0无效；1有效
     */
    public void setState(Byte state) {
        this.state = state;
    }
}