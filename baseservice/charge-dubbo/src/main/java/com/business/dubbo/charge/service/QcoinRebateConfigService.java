package com.business.dubbo.charge.service;

import com.business.api.entity.QcoinRebateConfig;
import com.business.dubbo.charge.dao.QcoinRebateConfigMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by chenll on 2017/7/15.
 */
@Service
public class QcoinRebateConfigService {

    @Autowired
    private QcoinRebateConfigMapper qcoinRebateConfigMapper;


    public QcoinRebateConfig findBy(String merchantAccount,String provinceCode){
        Example example = new Example(QcoinRebateConfig.class);
        example.createCriteria().andEqualTo("merchantAccount",merchantAccount).andEqualTo("provinceCode",provinceCode);
        List<QcoinRebateConfig> list = qcoinRebateConfigMapper.selectByExample(example);
        if ( list.size()==1){
            return list.get(0);
        }else if (list.size() > 1){
            throw new TooManyResultsException();
        }
        return null;
    }
}
