package com.openmart.core.business.product.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
/*@Entity
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double quantity;
    @OneToMany
    @JoinTable(name = "product_catalog")
    private List<Product> pro;

    public List<Product> getPro() {
        return pro;
    }

    public ProductCatalog(double quantity, List<Product> pro) {
        this.quantity = quantity;
        this.pro = pro;
    }

    public void setPro(List<Product> pro) {
        this.pro = pro;
    }

    public int getId() {
        return id;
    }

    public ProductCatalog() {
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pro=" + pro +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
} */
