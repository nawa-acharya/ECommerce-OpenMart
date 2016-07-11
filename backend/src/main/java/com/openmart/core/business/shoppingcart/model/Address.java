package com.openmart.core.business.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by user on 10-Jul-16.
 */
@Entity
public class Address implements Serializable{

    @Id
    @GeneratedValue
    private int id;


}
