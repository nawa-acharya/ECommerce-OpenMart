package com.openmart.core.business.shoppingcart.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by user on 10-Jul-16.
 */
public class Address {

    @Id
    private int id;

    @ManyToOne
    private User user;

}
