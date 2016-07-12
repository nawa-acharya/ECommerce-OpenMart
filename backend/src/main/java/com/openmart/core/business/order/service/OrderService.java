package com.openmart.core.business.order.service;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.util.OrderException;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.user.model.User;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
public interface OrderService {

    Order createOrderFromCart(User user, ShoppingCart shoppingCart);

    Order createOrder(User user, Order order) throws OrderException;

    void updateOrder(User user, Order order) throws OrderException;

    void deleteOrder(User user, Order order);

}
