package com.openmart.core.business.shoppingcart.dao;

import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.shoppingcart.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().update(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCart(int shoppingCartId) {
        return (ShoppingCart)sessionFactory.getCurrentSession().get(ShoppingCart.class, shoppingCartId);
    }
}
