package com.openmart.core.activemq;

/**
 * Created by Sandip on 7/3/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;

@Component
public class Producer implements CommandLineRunner {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
    }

    public void send(Object msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }


}