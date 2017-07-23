package com.business.recharge.service;

import com.business.recharge.dao.RequestLogMapper;
import com.business.recharge.entity.RequestLog;
import com.business.recharge.entity.enumtype.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by chenll on 2017/7/23.
 */
@Service
public class RequestLogService {

    @Autowired
    private RequestLogMapper requestLogMapper;


    public void saveLog(RequestType requestType, String data){
        RequestLog requestLog = new RequestLog();
        requestLog.setData(data);
        requestLog.setCreateBy("Unkown");
        requestLog.setCreateTime(new Date());
        requestLog.setType(RequestType.PLACEORDER);
        requestLogMapper.insert(requestLog);
    }
}
