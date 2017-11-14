package com.kafka.start;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by bin on 2017/3/6.
 */
public class BasicConsumer {
    public void get() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "35.165.169.235:9092");
        props.put("group.id", "test");      // 配置用户group
        props.put("enable.auto.commit", "true");    // 是否自动提交用户offset
        props.put("auto.commit.interval.ms", "1000");   //用户offset自动提交的频率
        props.put("session.timeout.ms", "30000");   // broker超时时间, 如果broker在该时间内没有回应心跳将被remove
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            if(!records.isEmpty()) {
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
            }
        }
    }

    public static void main(String[] args) {
        BasicConsumer consumer = new BasicConsumer();
        consumer.get();
    }
}
