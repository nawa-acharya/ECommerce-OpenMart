package com.openmart.core.configurations;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * Created by Sandip on 7/3/16.
 */
@Configuration
public class ActiveMQConfig {

    public static final String OPENMART_MAIL_QUEUE = "openmart.queue";

    @Bean
    public Queue helloJMSQueue() {
        return new ActiveMQQueue(OPENMART_MAIL_QUEUE);
    }
}