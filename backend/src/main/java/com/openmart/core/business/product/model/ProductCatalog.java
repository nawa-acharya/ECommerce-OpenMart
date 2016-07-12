package com.openmart.core.business.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Entity
public class ProductCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double quantity;

    private boolean available;

    public ProductCatalog(){
    }

    public ProductCatalog(double quantity, boolean available) {
        this.quantity = quantity;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
