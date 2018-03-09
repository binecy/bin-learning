package com.kafka.start;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by liangguobin
 */
public class ConsumerForTime {
    public void get() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "test");      // 配置用户group
        props.put("enable.auto.commit", "true");    // 是否自动提交消费者offset
        props.put("auto.commit.interval.ms", "1000");   //用户offset自动提交的频率
        props.put("session.timeout.ms", "30000");   // broker超时时间, 如果broker在该时间内没有回应心跳将被remove
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);


        Map<TopicPartition, Long> forTimeParam = new HashMap<>();
        // 分区
        TopicPartition topicPartition = new TopicPartition("test", 0);

        // 我们只想要60秒之前的消息的offset
        long timestamp = (System.currentTimeMillis() - 1000 * 60);

        forTimeParam.put(topicPartition, timestamp);

        Map<TopicPartition,OffsetAndTimestamp> startOffsetMap = consumer.offsetsForTimes(forTimeParam);



        long startOffset = 0;

        if(!startOffsetMap.containsKey(topicPartition)) {
            System.out.println("no record");
            return;
        }

        startOffset = startOffsetMap.get(topicPartition).offset();


        // 手动指定消费位置，无法自动负载均衡，所以要手动注册，才能消费
        consumer.assign(Arrays.asList(topicPartition));

        System.out.println("offset is : " + startOffset);

        // 指定新的位置
        consumer.seek(topicPartition, startOffset);

        ConsumerRecords<String, String> records = consumer.poll(1000 * 3);

        for (ConsumerRecord<String, String> record : records) {
            System.out.println("consumer record, key : " +  record.key() + " , val : " +  record.value());
        }

    }

    public static void main(String[] args) {
        ConsumerForTime consumer = new ConsumerForTime();
        consumer.get();
    }
}
