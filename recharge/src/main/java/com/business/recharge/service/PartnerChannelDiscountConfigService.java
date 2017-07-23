package com.business.recharge.service;

import com.business.recharge.dao.PartnerChannelDiscountConfigMapper;
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
