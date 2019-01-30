package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by emcc on 2019/1/28.
 */
@Service
public class MQConsumerService {

    @JmsListener(destination = "active.queue") // 监听指定消息队列
    public void receiveQueueA(String message) {
        System.out.println(message+"a");
    }

    @JmsListener(destination = "active.queue") // 监听指定消息队列
    public void receiveQueueB(String message) {
        System.out.println(message+"b");
    }

    @JmsListener(destination = "gytopic",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopicA(byte[] message) {
        System.out.print(new String(message));
    }

    @JmsListener(destination = "gytopic",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopicB(byte[] message) {
      System.out.print(new String(message));
    }
}
