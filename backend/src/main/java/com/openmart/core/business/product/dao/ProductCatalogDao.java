package com.openmart.core.business.product.dao;

import com.openmart.core.business.product.model.ProductCatalog;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
public interface ProductCatalogDao {

    public abstract List<ProductCatalog> getAllProductCatalogList();

    public abstract void addProductCatalog(ProductCatalog productCatalog);

    public abstract ProductCatalog getById(int id);

    public abstract void remove(int id);

    public abstract void update(ProductCatalog productCatalog);
}
