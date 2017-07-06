package com.business.acceptor.producer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by chenll on 2017/7/5.
 */
@Service
public class OrderProducer {

    private  Producer<String, byte[]> producer;

    public static final String TOPIC_ORDER="order_topic";

    @Autowired
    private Environment env;

    @PostConstruct
    public void init(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,env.getProperty("kafka.zookeeper.address"));
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        producer= new KafkaProducer(props);
    }

    @PreDestroy
    public void close(){
        producer.close();
    }


    /**
     *发送消息，发送的对象必须是可序列化的
     */
    public  Future<RecordMetadata> send(String topic, Serializable value) {
            //将对象序列化称字节码
            byte[] bytes= SerializationUtils.serialize(value);
            Future<RecordMetadata> future=producer.send(new ProducerRecord<String,byte[]>(topic,bytes));
            return future;
    }




}
