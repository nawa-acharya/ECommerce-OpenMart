package com.openmart.core.business.user.model;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Login login;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserImage image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> getOrders;
    private ShoppingCart shoppingCart;

    public User() {

    }

    public User(String firstName, String lastName, String email, Role role, Address address, Login login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.address = address;
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Login getLogin() {
        return login;
    }

    public UserImage getImage() {
        return image;
    }

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
