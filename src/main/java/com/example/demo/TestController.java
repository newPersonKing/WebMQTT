package com.example.demo;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emcc on 2019/1/28.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;
//
    @Autowired
    private Topic topic;
    @RequestMapping("/receiver")
    public void test(){
          System.out.print("test============");

        Destination destination = new ActiveMQTopic("AppAndSceneChangeTopic");
        Map<String, Object> map = new HashMap<>();
        map.put("JMSXGroupID", "AdParamChanged");

        jmsMessagingTemplate.convertAndSend(queue,"message");
        jmsMessagingTemplate.convertAndSend(topic,"topic");
//        jmsMessagingTemplate.convertAndSend(destination,"message",map);

    }
}
