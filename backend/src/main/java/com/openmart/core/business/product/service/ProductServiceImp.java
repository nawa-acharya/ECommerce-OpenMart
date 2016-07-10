package com.openmart.core.business.product.service;

import com.openmart.core.business.product.dao.ProductCatalogDao;
import com.openmart.core.business.product.dao.ProductDao;
import com.openmart.core.business.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductCatalogDao productCatalogDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
      /* List<ProductCatalog> list=new ArrayList<>();
        for(product:list){

        }*/
        this.productDao.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.productDao.update(product);
    }

    @Override
    @Transactional
    public List<Product> listProduct() {
        return this.productDao.getAllProduct();
    }

    @Override
    @Transactional
    public void removeProduct(int id) {
        this.productDao.delete(id);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return this.productDao.getProduct(id);
    }
}
