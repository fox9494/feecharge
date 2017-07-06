package com.business.acceptor.service;

import com.business.acceptor.dao.MerchantInfoMapper;
import com.business.acceptor.entity.MerchantInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/2.
 */
@Service
public class MerchantInfoService {

    @Autowired
    private MerchantInfoMapper merchantInfoMapper;


    public MerchantInfo findByAccount(String merchantAccount){
        Example example = new Example(MerchantInfo.class);
        example.createCriteria().andEqualTo("merchantAccount",merchantAccount);
        List<MerchantInfo> list = merchantInfoMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }
}
