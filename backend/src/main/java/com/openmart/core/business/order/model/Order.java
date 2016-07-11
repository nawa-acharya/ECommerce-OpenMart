package com.openmart.core.business.order.model;

import com.openmart.core.business.Payment.model.Payment;
import com.openmart.core.business.shoppingcart.model.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
@Entity
public class Order implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Address deliveryAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    private OrderStatus orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private  Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    private double totalPrice;

    public Order(){
    }

    public Order(List<OrderLine> orderLines, OrderStatus orderStatus, Date orderDate) {
        this.orderLines = orderLines;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void addProduct(OrderLine orderLine){
        this.orderLines.add(orderLine);
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
