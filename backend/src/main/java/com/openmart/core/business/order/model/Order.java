package com.openmart.core.business.order.model;

import com.openmart.core.business.Payment.model.Payment;
import com.openmart.core.business.user.model.ShippingAddress;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
@Entity(name="OrderTable")
public class Order implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private ShippingAddress shipping;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    private OrderStatus orderStatus;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date expectedDeliveryDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    private double totalPrice;

    public Order(){
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

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void addProduct(OrderLine orderLine){
        this.orderLines.add(orderLine);
    }

    public ShippingAddress getShipping() {
        return shipping;
    }

    public void setShipping(ShippingAddress shipping) {
        this.shipping = shipping;
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
