package com.openmart.core.business.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by user on 10-Jul-16.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }
}
