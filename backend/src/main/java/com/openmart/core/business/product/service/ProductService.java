package com.openmart.core.business.product.service;

import com.openmart.core.business.order.model.OrderLine;
import com.openmart.core.business.product.model.Product;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */

public interface ProductService {

    public void addProduct(Product product);
    public void updateProduct(Product product);
    public List<Product> listProduct();
    public void removeProduct(int id);
    public Product getById(int id);

    void updateCatalog(List<OrderLine> orderLines);
}
