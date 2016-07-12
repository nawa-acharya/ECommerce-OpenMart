package com.openmart.core.business.user.model;

import com.openmart.core.business.order.model.Order;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
public class User {
    @Id
    private int userId;
    private String name;
    @OneToOne (cascade = CascadeType.ALL)
    private Login login;
    @Enumerated
    private Role role = Role.ROLE_USER;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;

    public User() {

    }

    public User(String name, Login login) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", login=" + login +
                ", role=" + role +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        if(this.orders.contains(order)){
            orders.remove(order);
        }
        orders.add(order);
    }

    public boolean removeOrder(Order order){
        return this.orders.remove(order);
    }

}
