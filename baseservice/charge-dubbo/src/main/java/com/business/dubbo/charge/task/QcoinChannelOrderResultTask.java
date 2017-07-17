package com.business.dubbo.charge.task;

import com.business.api.entity.QcoinChannelOrder;
import com.business.api.entity.enumtype.BusinessType;
import com.business.api.entity.enumtype.OrderStatus;
import com.business.api.vo.ChannelQueryOrderReponse;
import com.business.api.vo.ChannelQueryOrderRequest;
import com.business.dubbo.charge.channel.ChannelAdaptor;
import com.business.dubbo.charge.channel.ChannelBusinessService;
import com.business.dubbo.charge.service.QcoinChannelOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by chenll on 2017/7/15.
 * 异步渠道结果查询
 * 可以等到获取订单状态结果
 */
public class QcoinChannelOrderResultTask implements Callable<QcoinChannelOrder> {

    private static Logger logger = LoggerFactory.getLogger(QcoinChannelOrderResultTask.class);

    private QcoinChannelOrderService qcoinChannelOrderService;

    //最长查询时间
    private Long maxQueryTime;

    //查询间隔时间
    private Long retryInterval;

    //首次查单时间
    private Long firstTime;

    //上次查单时间
    private Long lastTime;

    private String merchantAccount;

    private String channelOrderNo;


    public QcoinChannelOrderResultTask(QcoinChannelOrderService qcoinChannelOrderService,
                                       String merchantAccount, String channelOrderNo){
        this.qcoinChannelOrderService = qcoinChannelOrderService;
        this.merchantAccount = merchantAccount;
        this.channelOrderNo = channelOrderNo;
    }


    public QcoinChannelOrder call() throws Exception {
        QcoinChannelOrder entity = qcoinChannelOrderService.findByAccountAndOrderNo(merchantAccount, channelOrderNo);
        this.firstTime = System.currentTimeMillis();
        Integer status = entity.getOrderState();
        while(status == OrderStatus.PROCESSING.getValue()){
            long now = System.currentTimeMillis();

            if (now - firstTime >= maxQueryTime){
                logger.info("超过最大等待渠道结果时间，终止结果查询,ChannelOrderNo:{}",channelOrderNo);
                break;
            }

            if (now - lastTime >= retryInterval){
                entity = qcoinChannelOrderService.findByAccountAndOrderNo(merchantAccount, channelOrderNo);
                status = entity.getOrderState();
                lastTime = now;
            }

        }
        return entity;
    }


}
