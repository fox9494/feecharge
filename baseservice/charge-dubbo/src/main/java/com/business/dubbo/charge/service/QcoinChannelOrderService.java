package com.business.dubbo.charge.service;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.dubbo.charge.dao.QcoinChannelOrderMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/15.
 */
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
        qcoinChannelOrder.setChannelResult(channelQueryOrderReponse.toString());
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
