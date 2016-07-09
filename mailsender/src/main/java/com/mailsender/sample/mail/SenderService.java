package com.mailsender.sample.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

/**
 * Created by Sandip on 7/3/16.
 */
@Component
public class SenderService {

    @Autowired
    private JavaMailSender mailSender;

    @PostConstruct
    public void send() {
        System.out.println("Sending email");
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("tajbist2@gmail.com");
            //helper.setReplyTo("someone@localhost");
            helper.setFrom("sandip.necka@gmail.com");
            helper.setSubject("Hello From OpenMart Application");
            helper.setText("Here is my message");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);
        //return helper;
    }
}
