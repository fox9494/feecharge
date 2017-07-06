package com.business.acceptor.service;

import com.business.acceptor.dao.DictionaryBusinessInfoMapper;
import com.business.acceptor.entity.DictionaryBusinessInfo;
import com.business.acceptor.entity.MerchantInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/5.
 */
@Service
public class DictionaryBusinessInfoService {

    @Autowired
    private DictionaryBusinessInfoMapper dictionaryBusinessInfoMapper;

    public DictionaryBusinessInfo findByType(Integer type){
        Example example = new Example(DictionaryBusinessInfo.class);
        example.createCriteria().andEqualTo("type",type);
        List<DictionaryBusinessInfo> list = dictionaryBusinessInfoMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }
}
