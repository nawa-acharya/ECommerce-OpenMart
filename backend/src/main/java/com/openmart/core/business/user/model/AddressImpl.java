package com.openmart.core.business.user.model;

import javax.persistence.Entity;

/**
 * Created by Nawa on 7/9/2016.
 */
@Entity
public class AddressImpl implements Address {
    private int addressId;
    private String street;
    private String city;
    private String state;
    private int zip;
    private boolean isShippingAddress = false;
    private boolean isBillingAddress = false;
    private int id;

    public AddressImpl(String str, String c, String state, int zip,
                       boolean isShip, boolean isBill) {
        street = str;
        city = c;
        this.state = state;
        this.zip = zip;
        isShippingAddress = isShip;
        isBillingAddress = isBill;
    }

    public AddressImpl() {
    }

    public boolean isShippingAddress() {
        return isShippingAddress;
    }

    public boolean isBillingAddress() {
        return isBillingAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setShippingAddress(boolean shippingAddress) {
        isShippingAddress = shippingAddress;
    }

    public void setBillingAddress(boolean billingAddress) {
        isBillingAddress = billingAddress;
    }
}