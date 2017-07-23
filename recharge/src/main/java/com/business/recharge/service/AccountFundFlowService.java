package com.business.recharge.service;

import com.business.recharge.dao.AccountFundFlowMapper;
import com.business.recharge.entity.AccountFundFlow;
import com.business.recharge.entity.MerchantAccountInfo;
import com.business.recharge.entity.RechargeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by chenll on 2017/7/6.
 */
@Service
public class AccountFundFlowService {

    @Autowired
    private AccountFundFlowMapper accountFundFlowMapper;

    public void addRecord(){

    }

    public void addAcountFundFlow(RechargeOrder rechargeOrder, MerchantAccountInfo merchantAccountInfo, Long amount){
        AccountFundFlow accountFundFlow = new AccountFundFlow();
        accountFundFlow.setMerchantAccount(rechargeOrder.getMerchantAccount());
        accountFundFlow.setAccountType(0);
        accountFundFlow.setAmountBeforeChange(merchantAccountInfo.getBalance());
        accountFundFlow.setChangeAmount(Math.abs(amount));
        accountFundFlow.setAmountAfterChange(merchantAccountInfo.getBalance()-amount);
        accountFundFlow.setChangeTime(new Date());
        if (amount >= 0){
            accountFundFlow.setChangeReason("加款");
            accountFundFlow.setChangeType(1);
        }else {
            accountFundFlow.setChangeReason("减款");
            accountFundFlow.setChangeType(2);
        }
        accountFundFlow.setOrderNo(rechargeOrder.getOrderNo());
        accountFundFlow.setMerchantOrderNo(rechargeOrder.getMerchantOrderNo());
        accountFundFlow.setCreateTime(new Date());
        accountFundFlow.setUpdateTime(new Date());
        accountFundFlow.setCreateBy("unkown");
        accountFundFlow.setUpdateBy("unkown");
        accountFundFlowMapper.insert(accountFundFlow);
    }
}
