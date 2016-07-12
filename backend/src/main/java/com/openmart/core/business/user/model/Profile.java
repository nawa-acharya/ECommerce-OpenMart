package com.openmart.core.business.user.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nawa on 7/11/2016.
 */
//user profile
@Entity
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    @Lob
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private UserImage image;
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private BillingAddress billingAddress;

    public Profile() {

    }

    public Profile(UserImage image, String firstname, String lastname, String description, ShippingAddress shippingAddress, BillingAddress billingAddress) {
        this.image = image;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserImage getImage() {
        return image;
    }

    public void setImage(UserImage image) {
        this.image = image;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
