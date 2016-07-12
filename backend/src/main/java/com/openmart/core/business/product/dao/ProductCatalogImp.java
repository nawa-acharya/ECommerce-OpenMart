package com.openmart.core.business.product.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
/*@Repository
public class ProductCatalogImp implements ProductCatalogDao {
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<ProductCatalog> getAllProductCatalogList() {
        Session session = this.sf.getCurrentSession();
        List<ProductCatalog> productCatalogList = (List<ProductCatalog>) session.createQuery("from ProductCatalog");
        return productCatalogList;
    }

    @Override
    public void addProductCatalog(ProductCatalog productCatalog) {
        Session session = this.sf.getCurrentSession();
        session.persist(productCatalog);
    }

    @Override
    public ProductCatalog getById(int id) {
        Session session = this.sf.getCurrentSession();
        ProductCatalog productCatalog = (ProductCatalog) session.load(ProductCatalog.class, new Integer(id));

        return productCatalog;
    }

    @Override
    public void remove(int id) {
        Session session = this.sf.getCurrentSession();
        ProductCatalog productCatalog = (ProductCatalog) session.load(ProductCatalog.class, new Integer(id));
        if (null != productCatalog) {
            session.delete(productCatalog);
        }
    }

    @Override
    public void update(ProductCatalog productCatalog) {
        Session session = this.sf.getCurrentSession();
        session.update(productCatalog);
    }
} */
