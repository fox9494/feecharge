package com.business.chargeservice.service;

import com.business.api.entity.QcoinBlackList;
import com.business.chargeservice.dao.QcoinBlackListMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/5.
 */
@Service
public class QcoinBlackListServiceImpl {

    @Autowired
    private QcoinBlackListMapper qcoinBlackListMapper;

    public QcoinBlackList findByNumber(String qqNumber){
        Example example = new Example(QcoinBlackList.class);
        example.createCriteria().andEqualTo("qqNumber",qqNumber);
        List<QcoinBlackList> list = qcoinBlackListMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }

}
