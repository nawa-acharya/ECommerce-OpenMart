package com.mailsender.sample.mail;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * Created by Sandip on 7/3/16.
 */
@Component
public class SenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMessage(String confirmationEmailJson){
         ConfirmationEmail confirmationEmail = readFromJson(confirmationEmailJson);
        if(confirmationEmail == null){
            return;
        }
        System.out.println("Sending email");
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("mytrial4@gmail.com");
            //helper.setReplyTo("someone@localhost");
            helper.setFrom("mulum2@gmail.com");
            helper.setSubject(confirmationEmail.getSubject());
            helper.setText(confirmationEmail.getBody());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);
    }

    public ConfirmationEmail readFromJson(String jsonConfirmationEmail){
        ObjectMapper mapper = new ObjectMapper();
        try{
            Object obj = mapper.readValue(jsonConfirmationEmail, ConfirmationEmail.class);
            if(obj != null){
                return (ConfirmationEmail)obj;
            }
        }  catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    @PostConstruct
    public void send() {
    /*    System.out.println("Sending email");
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("mytrial4@gmail.com");
            //helper.setReplyTo("someone@localhost");
            helper.setFrom("mulum2@gmail.com");
            helper.setSubject("Hello From OpenMart Application");
            helper.setText("Here is my message");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);
        //return helper;*/
    }
}
