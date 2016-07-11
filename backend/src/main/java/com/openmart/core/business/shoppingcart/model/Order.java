package com.openmart.core.business.shoppingcart.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;

    @OneToOne
    private Address deliveryAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    private OrderStatus orderStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private  Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    public Order(){

    }
    public Order(User user, List<OrderLine> orderLines, OrderStatus orderStatus, Date orderDate) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof Order){
            Order order = (Order)obj;
            if(this.getId() == order.getId()){
                return true;
            }
        }
        return false;
    }
}
