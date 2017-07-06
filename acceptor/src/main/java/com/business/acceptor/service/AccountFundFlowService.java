package com.business.acceptor.service;

import com.business.acceptor.dao.AccountFundFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/6.
 */
@Service
public class AccountFundFlowService {

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;

    public void addRecord(){

    }
}
