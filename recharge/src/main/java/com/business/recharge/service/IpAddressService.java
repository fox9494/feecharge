package com.business.recharge.service;

import com.business.recharge.dao.IpAddressMapper;
import com.business.recharge.entity.IpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/15.
 */
@Service
public class IpAddressService {

    @Autowired
    private IpAddressMapper ipAddressMapper;

    public IpAddress findBy(String ip){
        return ipAddressMapper.selectByPrimaryKey(ip);
    }
}
