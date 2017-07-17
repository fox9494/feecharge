package com.business.dubbo.charge.service;

import com.business.api.entity.IpAddress;
import com.business.dubbo.charge.dao.IpAddressMapper;
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
