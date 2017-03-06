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
//        props.put("bootstrap.servers", "54.70.215.146:9092");
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "test");
//        props.put("zookeeper.connect","54.70.215.146:2181");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("my-topic"));
        while (true) {
//            System.out.println("....");
            ConsumerRecords<String, String> records = consumer.poll(100);
            if(!records.isEmpty()) {
                for (ConsumerRecord<String, String> record : records)
                    System.out.printf("offset = %d, key = %s, value = %s;", record.offset(), record.key(), record.value());
            }
        }
    }

    public static void main(String[] args) {
        BasicConsumer consumer = new BasicConsumer();
        consumer.get();
    }
}
