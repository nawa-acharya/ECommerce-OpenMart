package com.openmart.core.business.shoppingcart.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
public class OrderLine {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private Product product;

    private int quantity;

    public OrderLine(){

    }
    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof CartLine){
            OrderLine orderLine = (OrderLine) obj;
            if(this.getId() == orderLine.getId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode()  {
        int result = 1;
        result = 31 * result + getId();
        return result;
    }
}
