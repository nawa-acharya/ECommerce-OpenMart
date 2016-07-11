package com.openmart.core.business.product.dao;

import com.openmart.core.business.product.model.Product;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
public interface ProductDao {
    public abstract List<Product> getAllProduct();

    public abstract void addProduct(Product pro);

    public abstract Product getProduct(int id);

    public abstract void update(Product pro);

    public abstract void delete(int id);
}
