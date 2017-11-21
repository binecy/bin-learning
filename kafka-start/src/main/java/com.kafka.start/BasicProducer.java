package com.kafka.start;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by bin on 2017/3/6.
 */
public class BasicProducer {

    private void send(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "aws.binecy.com:9092");
        // Producer接受broker ack的模式
        // 0: 如果设置为零，则生产者不会等待来自服务器的任何确认。
        // 1: leader接收成功并写入本地日志就返回ack   如果leader在接收记录之后但在追随者复制之前立即崩溃，那么记录将会丢失。
        // all:这意味着领导者将等待全套的in-sync副本确认记录。
        props.put("acks", "all");
        props.put("retries", 0);    // 失败重发次数
        // 批量发送记录的最大值

        // 如果有多个记录被发送到同一个分区，生产者就会尝试将记录批量提交。
        // batch.size配置默认的批量大小, 单位字节。 kafka不会发送大于此大小的批量记录。
        // 过小可能降低吞吐量， 过大可能会更浪费一点的内存
        props.put("batch.size", 16384); //


        // Producer可用于缓冲等待发送记录的最大字节数
        props.put("buffer.memory", 33554432);
        // 如果缓冲区已满或metadata不可用Producer将阻塞  max.block.ms配置可阻塞的多长时间，超时它将抛出一个异常
        props.put("max.block.ms", 60000);

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for(int i = 0; i < 5; i++)
            producer.send(new ProducerRecord<>("test", "from java : " + i ));


        producer.close();

    }



    public static void main( String[] args )
    {
        new BasicProducer().send();
    }
}
