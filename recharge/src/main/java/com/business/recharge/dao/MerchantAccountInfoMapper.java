package com.business.recharge.dao;

import com.business.recharge.entity.MerchantAccountInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MerchantAccountInfoMapper extends Mapper<MerchantAccountInfo> {


    public List<MerchantAccountInfo> selectBy(@Param(value = "merchantAccount") String merchantAccount);

    public void updateBalance(@Param(value = "merchantAccount") String merchantAccount, @Param(value = "balance") Long balance);
}