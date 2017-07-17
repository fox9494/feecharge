package com.business.dubbo.charge.notify;

import com.alibaba.fastjson.JSON;
import com.business.api.vo.NotifyMerchantVO;
import com.business.dubbo.charge.utils.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * Created by chenll on 2017/7/17.
 */
public class NotifyMerchantService {

    public static String  notifyMerchant(String url,NotifyMerchantVO request){
        return HttpUtil.doPost(url, JSON.toJSONString(request));
    }
}
