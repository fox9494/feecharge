package com.business.acceptor.service;

import com.business.acceptor.dao.MerchantApplyBusinessMapper;
import com.business.acceptor.entity.MerchantApplyBusiness;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/4.
 */
@Service
public class MerchantApplyBusinessService {

    @Autowired
    private MerchantApplyBusinessMapper merchantApplyBusinessMapper;


    /**
     * 根据账户和业务类型查询
     * @param merchantAccount
     * @param businessType
     * @return
     */
    public MerchantApplyBusiness findBy(String merchantAccount, Integer businessType){
        Example example = new Example(MerchantApplyBusiness.class);
        example.createCriteria().andEqualTo("merchantAccount",merchantAccount).andEqualTo("businessType",businessType);
        List<MerchantApplyBusiness> list = merchantApplyBusinessMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }
}
