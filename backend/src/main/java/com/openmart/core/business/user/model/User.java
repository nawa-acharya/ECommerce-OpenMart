package com.openmart.core.business.user.model;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;

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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserImage image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> getOrders;
    private ShoppingCart shoppingCart;

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
    public void setImage(UserImage image) {
        this.image = image;
    }

    public List<Order> getGetOrders() {
        return getOrders;
    }

    public void setGetOrders(List<Order> getOrders) {
        this.getOrders = getOrders;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
