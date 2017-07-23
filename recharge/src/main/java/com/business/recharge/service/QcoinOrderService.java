package com.business.recharge.service;

import com.business.recharge.dao.QcoinOrderMapper;
import com.business.recharge.entity.QcoinChannelOrder;
import com.business.recharge.entity.QcoinOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/17.
 */
@Service
public class QcoinOrderService {

    @Autowired
    private QcoinOrderMapper qcoinOrderMapper;

    /**
     * 根据子订单更新主订单
     * @param qcoinChannelOrder
     * @return
     */
    public int updateStatus(QcoinChannelOrder qcoinChannelOrder){
        QcoinOrder qcoinOrder = new QcoinOrder();
        qcoinOrder.setOrderNo(qcoinChannelOrder.getOrderNo());
        qcoinOrder = qcoinOrderMapper.selectOne(qcoinOrder);
        if (qcoinOrder != null){
            qcoinOrder.setOrderState(qcoinChannelOrder.getOrderState());
            return qcoinOrderMapper.updateByPrimaryKey(qcoinOrder);
        }
        return -1;
    }

    /**
     * 根据子订单更新主订单
     * @return
     */
    public int updateStatus(String orderNo,Integer status){
        QcoinOrder qcoinOrder = new QcoinOrder();
        qcoinOrder.setOrderNo(orderNo);
        qcoinOrder = qcoinOrderMapper.selectOne(qcoinOrder);
        if (qcoinOrder != null){
            qcoinOrder.setOrderState(status);
            return qcoinOrderMapper.updateByPrimaryKey(qcoinOrder);
        }
        return -1;
    }
}
