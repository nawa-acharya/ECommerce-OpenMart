package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Nawa on 7/11/2016.
 */
@Entity
public class ShippingAddress implements Address {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public ShippingAddress(String str, String c, String state, String zip) {
        street = str;
        city = c;
        this.state = state;
        this.zip = zip;
    }

    public ShippingAddress() {
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getZip() {
        return zip;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setStreet(String s) {
        this.street = s;
    }

    @Override
    public void setCity(String s) {
        this.city = s;
    }

    @Override
    public void setState(String s) {
        this.state = s;
    }

    @Override
    public void setZip(String s) {
        this.zip = s;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean isShipping() {
        return true;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
