package com.mailsender.rabbitmq;

import com.mailsender.mail.SenderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Endalkachew on 7/13/16.
 */

@Component
public class Consumer implements MessageListener{

    @Override
    public void onMessage(Message message) {
        if(message == null){
            System.err.println("Invalid message");
            return;
        }
        String messageBody =  new String(message.getBody());
        System.out.println("Recieved message" +  messageBody);
        new SenderService().sendMessage(messageBody);
    }
}