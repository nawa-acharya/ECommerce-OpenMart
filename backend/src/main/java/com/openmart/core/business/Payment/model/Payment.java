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

    private double ammount;

    private PaymentType paymentType;

    private PaymentStatus paymentStatus;

    @OneToOne
    private Order order;

    public Payment(){}

    public Payment(double ammount, PaymentType paymentType, PaymentStatus paymentStatus, Order order) {
        this.ammount = ammount;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
