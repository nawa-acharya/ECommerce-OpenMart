package com.openmart.core.business.Payment.model;

import com.openmart.core.business.order.model.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private PaymentType paymentType;

    private PaymentStatus paymentStatus;

    public Payment(){}

    public Payment(PaymentType paymentType, PaymentStatus paymentStatus) {
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
