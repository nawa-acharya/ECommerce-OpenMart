package com.openmart.core.business.user.model;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
@Entity
@SecondaryTable(name="logintable")
                //pkJoinColumns={@PrimaryKeyJoinColumn(name="loginId", referencedColumnName="userId") })

public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    @Column(table = "logintable")
    private String username;
    @Column (table = "logintable")
    private String password;
    @Enumerated
    private Role role = Role.ROLE_USER;
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private BillingAddress billingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;
    public User() {

    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                ", profile=" + profile +
                '}';
    }
}
