package com.business.recharge.notify;

import com.alibaba.fastjson.JSON;
import com.business.recharge.utils.HttpUtil;
import com.business.recharge.vo.NotifyMerchantVO;

/**
 * Created by chenll on 2017/7/17.
 */
public class NotifyMerchantService {

    public static String  notifyMerchant(String url,NotifyMerchantVO request){
        return HttpUtil.doPost(url, JSON.toJSONString(request));
    }
}
