package com.business.dubbo.charge.service;

import com.business.api.entity.PartnerChannelDiscountConfig;
import com.business.dubbo.charge.dao.PartnerChannelDiscountConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/9.
 */
@Service
public class PartnerChannelDiscountConfigService {

    @Autowired
    private PartnerChannelDiscountConfigMapper partnerChannelDiscountConfigMapper;
}
