package com.business.dubbo.charge.service;

import com.business.api.entity.QcoinMerchantUsableChannel;
import com.business.dubbo.charge.dao.QcoinMerchantUsableChannelMapper;
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
    public List<QcoinMerchantUsableChannel> findBy(String merchantAccount, String channelId,Integer state){
        Example example = new Example(QcoinMerchantUsableChannel.class);
        example.setOrderByClause("orderSort");
        example.createCriteria().andEqualTo("merAccount",merchantAccount).andEqualTo("channelNo",channelId).
                andEqualTo("state",state);
        return qcoinMerchantUsableChannelMapper.selectByExample(example);
    }
}
