package com.business.dubbo.charge.service;

import com.business.api.entity.RechargeOrder;
import com.business.dubbo.charge.dao.RechargeOrderMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/13.
 */
@Service
public class RechargeOrderService {

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
