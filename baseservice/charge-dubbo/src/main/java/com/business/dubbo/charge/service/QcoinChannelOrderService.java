package com.business.dubbo.charge.service;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.vo.ChannelPlaceOrderCallbackRequest;
import com.business.api.vo.ChannelPlaceOrderCallbackResponse;
import com.business.api.vo.ChannelPlaceOrderResponse;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.dubbo.charge.dao.QcoinChannelOrderMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/15.
 */
@Service
public class QcoinChannelOrderService {

    @Autowired
    private QcoinChannelOrderMapper qcoinChannelOrderMapper;


    public void updatePartnerOrderNo(String partnerOrderNo,String merchantAccount,String channelOrderNo){
        QcoinChannelOrder qcoinChannelOrder = this.findByAccountAndOrderNo(merchantAccount,channelOrderNo);
        if (qcoinChannelOrder!=null){
            qcoinChannelOrder.setPartnerOrderNo(partnerOrderNo);
            Example example = new Example(QcoinChannelOrder.class);
            example.createCriteria().andEqualTo("merchantAccount",merchantAccount).andEqualTo("channelOrderNo",channelOrderNo);
            qcoinChannelOrderMapper.updateByExampleSelective(qcoinChannelOrder,example);
        }

    }

    //根据查单结果更新
    public void updateChannelOrder(QcoinChannelOrder qcoinChannelOrder,ChannelQueryOrderReponse channelQueryOrderReponse){
        qcoinChannelOrder.setOrderState(channelQueryOrderReponse.getOrderVO().getOrderStatus());
        qcoinChannelOrder.setPartnerOrderNo(channelQueryOrderReponse.getOrderVO().getPartnerOrderNo());
        qcoinChannelOrder.setSuccessAmount(channelQueryOrderReponse.getOrderVO().getSuccessAmount());
        qcoinChannelOrder.setChannelResult(channelQueryOrderReponse.toString());
        qcoinChannelOrderMapper.updateByPrimaryKey(qcoinChannelOrder);
    }

    //根据下单结果更新
    public void updateByPlaceOrderResponse(QcoinChannelOrder qcoinChannelOrder,ChannelPlaceOrderResponse response){
        qcoinChannelOrder.setOrderState(response.getOrderVO().getOrderStatus());
        qcoinChannelOrder.setPartnerOrderNo(response.getOrderVO().getPartnerOrderNo());
        qcoinChannelOrder.setSuccessAmount(response.getOrderVO().getSuccessAmount());
        qcoinChannelOrder.setChannelResult(response.toString());
        qcoinChannelOrderMapper.updateByPrimaryKey(qcoinChannelOrder);
    }

    //根据回调结果更新
    public void updateByPlaceOrderCallbackResponse(QcoinChannelOrder qcoinChannelOrder,ChannelPlaceOrderCallbackRequest request){
        qcoinChannelOrder.setOrderState(request.getPlaceOrderCallbackVO().getOrderStatus());
        qcoinChannelOrder.setSuccessAmount(request.getPlaceOrderCallbackVO().getSuccessAmount());
        qcoinChannelOrder.setChannelResult(request.toString());
        qcoinChannelOrderMapper.updateByPrimaryKey(qcoinChannelOrder);
    }

    public QcoinChannelOrder findByAccountAndOrderNo(String merchantAccount,String channelOrderNo){
        Example example = new Example(QcoinChannelOrder.class);
        example.createCriteria().andEqualTo("merchantAccount",merchantAccount).andEqualTo("channelOrderNo",channelOrderNo);
        List<QcoinChannelOrder> list = qcoinChannelOrderMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }
}
