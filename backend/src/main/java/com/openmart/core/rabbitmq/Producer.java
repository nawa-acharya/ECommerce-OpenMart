package com.openmart.core.rabbitmq;

/**
 * Created by Sandip on 7/3/16.
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Producer {

    private AmqpTemplate amqpTemplate;

    @PostConstruct
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("sender-context.xml");
        amqpTemplate = context.getBean(AmqpTemplate.class);
    }
    public void send(String msg) {
        amqpTemplate.convertAndSend("mySpringQueue", msg);
    }


}