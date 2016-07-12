package com.openmart.core.business.product.dao;

import com.openmart.core.business.product.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
@Repository
public class ProductDaoImp implements ProductDao {

    @Autowired
    private SessionFactory sf;


    @Override
    public List<Product> getAllProduct() {
        Session session = this.sf.getCurrentSession();
        List<Product> productList;
        productList = (List<Product>) session.createQuery("from Product").list();
        return productList;
    }

    @Override
    public void addProduct(Product pro) {
        Session session = this.sf.getCurrentSession();
        session.save(pro);
    }

    @Override
    public Product getProduct(int id) {
        Session session = this.sf.getCurrentSession();
        Product pro = (Product) session.get(Product.class, new Integer(id));
        return pro;
    }

    @Override
    public void update(Product pro) {
        Session session = this.sf.getCurrentSession();
        session.update(pro);
    }

    @Override
    public void delete(int id) {
        Session session = this.sf.getCurrentSession();
        Product pro = (Product) session.load(Product.class, new Integer(id));
        if (pro != null) {
            session.delete(pro);
        }
    }
}
