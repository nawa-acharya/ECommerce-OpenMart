package com.openmart.core.business.order.util;

import java.io.Serializable;

/**
 * Created by user on 13-Jul-16.
 */
public class ConfirmationEmail implements Serializable{
    private String sendTo;
    private String subject;
    private String body;

    public ConfirmationEmail() {
    }

    public ConfirmationEmail(String sendTo, String subject, String body) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.body = body;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
