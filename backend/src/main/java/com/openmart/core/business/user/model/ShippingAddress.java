package com.openmart.core.business.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Nawa on 7/11/2016.
 */
//shipping address
@Entity
public class ShippingAddress implements Address {
    @Id
    @GeneratedValue
    private int id;
    //@NotNull
    private String firstName;
   // @NotNull
    private String lastName;
    //@NotNull
    private String street;
   // @NotNull
    private String city;
   // @NotNull
    private String state;
    //@Pattern(regexp = "\\d{10}")
    private String phone;
   // @Pattern(regexp = "(^\\d{5}$)|(^\\d{5}-\\d{4}$)")
    private String postcode;
  //  @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$")
    private String zip;

    public ShippingAddress() {
    }

    public ShippingAddress(String firstName, String lastName, String street, String city, String state, String phone, String postcode, String zip) {
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

    public boolean isShipping() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
