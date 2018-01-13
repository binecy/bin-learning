package com.springboot.start.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue helloQueue2() {
        return new Queue("hello2");
    }

//    @Bean
//    public MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }


    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    Receiver receiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("hello");
        container.setMessageListener(new MessageListenerAdapter(receiver, "receiveMessage"));
        return container;
    }


//    @Bean
//    public MessageListenerAdapter listenerAdapter2(Receiver2 receiver2) {
//        return new MessageListenerAdapter(receiver2, "receiveMessage");
//    }


    @Bean
    public SimpleMessageListenerContainer container2(ConnectionFactory connectionFactory,Receiver2 receiver2) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("hello2");
        container.setMessageListener(new MessageListenerAdapter(receiver2, "receiveMessage"));
        return container;
    }
}
