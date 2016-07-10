package com.openmart.core.business.product.service;

import com.openmart.core.business.product.dao.ProductCatalogDao;
import com.openmart.core.business.product.model.ProductCatalog;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
public class ProductCatalogServiceImp implements ProductCatalogService {
    private ProductCatalogDao productCatalogDao;

    public void setProductCatalogDao(ProductCatalogDao productCatalogDao) {
        this.productCatalogDao = productCatalogDao;
    }

    @Override
    public void addProductCatalog(ProductCatalog productCatalog) {
        this.productCatalogDao.addProductCatalog(productCatalog);
    }

    @Override
    public void updateProductCatalog(ProductCatalog productCatalog) {
        this.productCatalogDao.update(productCatalog);
    }

    @Override
    public List<ProductCatalog> listProductCatalog() {
        return this.productCatalogDao.getAllProductCatalogList();
    }

    @Override
    public void remove(int id) {
        this.productCatalogDao.remove(id);
    }

    @Override
    public ProductCatalog getById(int id) {
        return this.productCatalogDao.getById(id);
    }
}
