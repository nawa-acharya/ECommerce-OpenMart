package com.mailsender.sample.activemq;

import com.mailsender.sample.mail.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Sandip on 7/3/16.
 */


@Component
public class Consumer {

    @Autowired
    private SenderService senderService;

    @JmsListener(destination = "openmart.queue")
    public void receiveQueue(String confirmationEmail) {
        System.out.println("Received message... Sending confirmation email");
        senderService.sendMessage(confirmationEmail);
    }

    @PostConstruct
    public void create(){
        System.out.println("Consumer is created");
    }

}