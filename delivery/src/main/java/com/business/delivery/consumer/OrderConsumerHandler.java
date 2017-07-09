package com.business.delivery.consumer;

import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenll on 2017/7/8.
 */
@Service
public class OrderConsumerHandler {

    private static Logger logger = LoggerFactory.getLogger(OrderConsumerHandler.class);

    private Consumer<String, byte[]> consumer;

    public static final String TOPIC_ORDER="order_topic";

    @Autowired
    private Environment env;

    @PostConstruct
    public void init(){
        logger.info("开始初始化kafka消费者参数");
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,env.getProperty("kafka.zookeeper.address"));
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put("retries", 0);
        props.put("enable.auto.commit", "false");
        props.put("group.id", "order_group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        consumer= new KafkaConsumer<String, byte[]>(props);
        consumer.subscribe(Arrays.asList(TOPIC_ORDER));
        this.execute(3);
    }

    private void execute(int workerNum){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(workerNum, workerNum, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(500), new ThreadPoolExecutor.CallerRunsPolicy());
        while(true){
            ConsumerRecords<String,byte[]> records = consumer.poll(200);
            logger.info("接受到kafka消息,数量:{}",records.count());
            for (ConsumerRecord record:records) {
                executor.submit(new Worker(record));
            }
        }

    }
}
