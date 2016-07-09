package com.mailsender.sample.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Sandip on 7/3/16.
 */


@Component
public class Consumer {

    @JmsListener(destination = "hello.queue")
    public void receiveQueue(String text) {
        System.out.println(text);
    }

    @JmsListener(destination = "sample.queue")
    public void receive(String text) {
        System.out.println(text);
    }
    @PostConstruct
    public void create(){
        System.out.println("Consumer is created");
    }

}