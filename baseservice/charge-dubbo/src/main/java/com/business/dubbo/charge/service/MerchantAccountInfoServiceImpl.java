package com.business.dubbo.charge.service;

import com.business.api.entity.MerchantAccountInfo;
import com.business.dubbo.charge.dao.MerchantAccountInfoMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenll on 2017/7/6.
 */
@Component
public class MerchantAccountInfoServiceImpl {

    @Autowired
    private MerchantAccountInfoMapper merchantAccountInfoMapper;


    //使用了悲观锁
    public MerchantAccountInfo findByAccount(String merchantAccount){
        List<MerchantAccountInfo> list = merchantAccountInfoMapper.selectBy(merchantAccount);
        if (list.size()==1){
            return list.get(0);
        }
        if (list.size() > 1){
            throw new TooManyResultsException();
        }

        return null;
    }

    public void updateBalance(String merchantAccount,Long balance){
        merchantAccountInfoMapper.updateBalance(merchantAccount,balance);
    }
}
