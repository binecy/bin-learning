package com.springboot.start.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    Receiver receiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("hello");
        container.setMessageListener(new MessageListenerAdapter(receiver, "receiveMessage"));
        return container;
    }


    @Bean
    public SimpleMessageListenerContainer container2(ConnectionFactory connectionFactory,Receiver2 receiver2) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("hello2");
        container.setMessageListener(new MessageListenerAdapter(receiver2, "receiveMessage"));
        return container;
    }



    // ------- topic -------
    //创建两个队列
    @Bean(name = "topicQueue")
    public Queue topicQueue() {
        return new Queue("topic.message");
    }

    @Bean(name = "topicQueue2")
    public Queue queuemessages(){
        return new Queue("topic.message2");
    }


    //创建交换机
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding binding1(@Qualifier("topicQueue")Queue topicQueue, TopicExchange exchange){
        return BindingBuilder.bind(topicQueue).to(exchange).with("topic.message");
    }


    @Bean
    Binding binding2(@Qualifier("topicQueue2")Queue topicQueue, TopicExchange exchange){
        return BindingBuilder.bind(topicQueue).to(exchange).with("topic.#");
    }



    // ------- topic -------
    // 广播
    @Bean
    public Queue queue() {
        return new Queue("fanout-queue"); //队列持久
    }
    @Bean
    public Queue queue2() {
        return new Queue("fanout-queue2"); //队列持久
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }
    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }


}
