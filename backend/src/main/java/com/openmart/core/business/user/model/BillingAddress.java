package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Nawa on 7/9/2016.
 */
@Entity
public class BillingAddress implements Address {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private long phone;
    private String postcode;
    private String zip;

    public BillingAddress() {
    }

    public BillingAddress(String firstName, String lastName, String street, String city, String state, long phone, String postcode, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.postcode = postcode;
        this.zip = zip;
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

    public boolean isBilling() {
        return true;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}