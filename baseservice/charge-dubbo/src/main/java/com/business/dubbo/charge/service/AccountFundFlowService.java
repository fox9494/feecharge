package com.business.dubbo.charge.service;

import com.business.dubbo.charge.dao.AccountFundFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chenll on 2017/7/6.
 */
@Component
public class AccountFundFlowService {

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;

    public void addRecord(){

    }
}
