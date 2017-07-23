package com.business.recharge.service;

import com.business.recharge.dao.PartnerChannelMapper;
import com.business.recharge.entity.PartnerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/9.
 */
@Service
public class PartnerChannelService {

    @Autowired
    private PartnerChannelMapper partnerChannelMapper;

    public PartnerChannel findByChannel(Integer channelId){
        return partnerChannelMapper.selectByPrimaryKey(channelId);
    }
}
