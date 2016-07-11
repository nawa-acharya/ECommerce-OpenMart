package com.openmart.core.business.order.service;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.shoppingcart.model.Address;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
public interface OrderService {

    Order createOrderFromCart(ShoppingCart shoppingCart);

    Order createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);

}
