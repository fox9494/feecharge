package com.business.recharge.service;

import com.business.recharge.dao.QcoinMerchantUsableChannelMapper;
import com.business.recharge.entity.QcoinMerchantUsableChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/9.
 */
@Service
public class QcoinChannelService {

    @Autowired
    private QcoinMerchantUsableChannelMapper qcoinMerchantUsableChannelMapper;


    /**
     * 根据商户和渠道编号查询，可以传入任意一个
     * @param merchantAccount
     * @param channelId
     * @return
     */
    public List<QcoinMerchantUsableChannel> findBy(String merchantAccount, String channelId, Integer state){
        Example example = new Example(QcoinMerchantUsableChannel.class);
        example.setOrderByClause("order_sort");
        example.createCriteria().andEqualTo("merchantAccount",merchantAccount).andEqualTo("channelId",channelId).
                andEqualTo("state",state);
        return qcoinMerchantUsableChannelMapper.selectByExample(example);
    }
}
