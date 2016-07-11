package com.openmart.web.shop.controllers.order.facade;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 11-Jul-16.
 */
public interface OrderController {

    Order createNewOrderFromCart(ShoppingCart shoppingCart);

    Order createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}