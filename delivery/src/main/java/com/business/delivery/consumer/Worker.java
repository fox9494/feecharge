package com.business.delivery.consumer;

import com.business.api.entity.RechargeOrder;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.util.SerializationUtils;

/**
 * Created by chenll on 2017/7/9.
 */
public class Worker implements Runnable {

    private ConsumerRecord<String,byte[]> consumerRecord;

    public Worker(ConsumerRecord record){
        this.consumerRecord = record;
    }

    //处理逻辑
    public void run() {

        RechargeOrder rechargeOrder = (RechargeOrder) SerializationUtils.deserialize(consumerRecord.value());
        System.out.println("consumerRecord = " + rechargeOrder.toString());
    }
}
