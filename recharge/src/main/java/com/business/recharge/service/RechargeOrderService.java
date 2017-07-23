package com.business.recharge.service;

import com.business.recharge.dao.RechargeOrderMapper;
import com.business.recharge.entity.RechargeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by chenll on 2017/7/13.
 */
@Service
public class RechargeOrderService {

    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;


    public int verifyMercantOrderNo(String merchantAccount,String merchantOrderNo){
        Example example = new Example(RechargeOrder.class);
        example.createCriteria().andEqualTo("merchantOrderNo",merchantOrderNo).andEqualTo("merchantAccount",merchantAccount);
        return rechargeOrderMapper.selectCountByExample(example);
    }

    public void updateStatus(String orderNo,Integer status){
        RechargeOrder order = new RechargeOrder();
        order.setOrderNo(orderNo);
        order =  rechargeOrderMapper.selectOne(order);
        order.setOrderState(status);
        rechargeOrderMapper.updateByPrimaryKey(order);

    }
    public RechargeOrder findByOrderNo(String orderNo){
        RechargeOrder order = new RechargeOrder();
        order.setOrderNo(orderNo);
        return rechargeOrderMapper.selectOne(order);
    }
}
