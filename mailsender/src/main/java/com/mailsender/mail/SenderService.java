package com.mailsender.mail;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sandip on 7/3/16.
 */

public class SenderService {


    public void sendMessage(String confirmationEmailJson){
         ConfirmationEmail confirmationEmail = readFromJson(confirmationEmailJson);
        if(confirmationEmail == null){
            return;
        }
        System.out.println("Sending email");
        sendEmail(confirmationEmail);

    }

    public void sendEmail(ConfirmationEmail confirmationEmail){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mulum2@gmail.com","");
                    }
                });

        try {

            Message message = new MimeMessage(session);


            message.setFrom(new InternetAddress("mulum2@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(confirmationEmail.getSendTo()));
            message.setSubject(confirmationEmail.getSubject());
            message.setText(confirmationEmail.getBody());

            Transport.send(message);

            System.out.println("Email sent");

        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
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
}
