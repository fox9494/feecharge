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
 * 查单线程
 * 可以等到获取订单状态结果
 */
public class ChannelQueryOrderTask implements Callable<Integer> {

    private static Logger logger = LoggerFactory.getLogger(ChannelQueryOrderTask.class);

    private QcoinChannelOrderService qcoinChannelOrderService;

    //最长查询时间
    private Long maxQueryTime;

    //首次间隔时间
    private Long firstInterval;

    //查询间隔时间
    private Long retryInterval;

    //首次查单时间
    private Long firstTime;

    //上次查单时间
    private Long lastTime;

    private String merchantAccount;

    private String channelOrderNo;

    private Integer channelId ;

    public ChannelQueryOrderTask(QcoinChannelOrderService qcoinChannelOrderService, Long firstTime,
                                 String merchantAccount, String channelOrderNo, Integer channelId){
        this.qcoinChannelOrderService = qcoinChannelOrderService;
        this.firstTime = firstTime;
        this.channelId = channelId;
        this.merchantAccount = merchantAccount;
        this.channelOrderNo = channelOrderNo;
    }


    public Integer call() throws Exception {
        QcoinChannelOrder entity = qcoinChannelOrderService.findByAccountAndOrderNo(merchantAccount, channelOrderNo);
        Integer status = entity.getOrderState();
        boolean firstCheck = true;
        while(status == OrderStatus.PROCESSING.getValue()){
            long now = System.currentTimeMillis();
            if ((now - firstTime >= firstInterval) && firstCheck){//启动查单
                ChannelQueryOrderReponse response = this.getCheckOrder(entity);
                status = response.getOrderVO().getOrderStatus();
                if (status != OrderStatus.PROCESSING.getValue()){
                    //更新数据库
                    qcoinChannelOrderService.updateChannelOrder(entity,response);
                }
                lastTime = now;
                firstCheck = false;
            }

            if (now - firstTime >= maxQueryTime){
                logger.info("超过最大查单时间，终止查单,ChannelOrderNo:{}",channelOrderNo);
                break;
            }

            if (now - lastTime >= retryInterval){
                ChannelQueryOrderReponse response = this.getCheckOrder(entity);
                status = response.getOrderVO().getOrderStatus();
                if (status != OrderStatus.PROCESSING.getValue()){
                    //更新数据库
                    qcoinChannelOrderService.updateChannelOrder(entity,response);
                }
                lastTime = now;
            }

        }
        return status;
    }


    private ChannelQueryOrderReponse getCheckOrder(QcoinChannelOrder entity ){
        ChannelBusinessService channelBusinessService = ChannelAdaptor.getChannel(channelId);
        ChannelQueryOrderRequest request = new ChannelQueryOrderRequest();
        request.setMerchantAccount(merchantAccount);
        request.setPartnerOrderNo(entity.getPartnerOrderNo());
        request.setBusinessType(BusinessType.QICON.getValue());
        request.setRequestTime(System.currentTimeMillis());
        request.setSign("");//TODO
       return channelBusinessService.requestChannelQueryOrder(request);
    }
}
