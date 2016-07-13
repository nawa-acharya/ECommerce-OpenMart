package com.mailsender.sample.activemq;

import com.mailsender.sample.mail.SenderService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Sandip on 7/3/16.
 */


@Component
@RabbitListener(queues = "foo")
public class Consumer {

    @Autowired
    private SenderService senderService;

/*    @JmsListener(destination = "openmart.queue")
    public void receiveQueue(String confirmationEmail) {
        System.out.println("Received message... Sending confirmation email");
        senderService.sendMessage(confirmationEmail);
    } */

    @PostConstruct
    public void create(){
        System.out.println("Consumer is created");
    }


    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload String confirmationEmail) {
        System.out.println("Received message... Sending confirmation email");
        senderService.sendMessage(confirmationEmail);
    }

}