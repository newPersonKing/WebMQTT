package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by emcc on 2019/1/28.
 */
@Configuration
@EnableJms
public class JmsConfiguration {

    // topic模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    // queue模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    private static final String QUEUE_NAME = "active.queue";

    private static final String TOPIC_NAME = "gytopic";

    @Bean
    public Queue queueA(){
        return new ActiveMQQueue(QUEUE_NAME);
    }

//    @Bean
//    public Queue queueB(){
//        return new ActiveMQQueue("active.queue==B");
//    }


    @Bean
    public Topic topicA(){
        return new ActiveMQTopic(TOPIC_NAME);
    }

//    @Bean
//    public Topic topicB(){
//        return new ActiveMQTopic("active.topic==B");
//    }

}
