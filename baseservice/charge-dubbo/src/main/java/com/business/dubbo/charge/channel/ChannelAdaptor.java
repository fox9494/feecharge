package com.business.dubbo.charge.channel;

import com.business.dubbo.charge.channel.jiaoyiba.JiaoyibaBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenll on 2017/7/15.
 */
public class ChannelAdaptor {

    private static Map<Integer,ChannelBusinessService> map = new HashMap<Integer,ChannelBusinessService>(16);

    static {
        map.put(1,new JiaoyibaBusinessService());
        //依次添加其他上游接口
    }


    public static ChannelBusinessService getChannel(Integer channelId){
        return map.get(channelId);
    }


}
