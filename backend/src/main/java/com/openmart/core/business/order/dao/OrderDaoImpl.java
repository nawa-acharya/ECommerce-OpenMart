package com.openmart.core.business.order.dao;

import com.openmart.core.business.order.model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Order saveOrder(Order order) {
        return (Order)sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }
}
