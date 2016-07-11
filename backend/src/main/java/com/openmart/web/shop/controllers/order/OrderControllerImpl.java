package com.openmart.web.shop.controllers.order;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.service.OrderService;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.web.shop.controllers.order.facade.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Controller
@RequestMapping(value = "/rest/orders")
public class OrderControllerImpl implements OrderController{

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping(value = "/createfromcart")
    @ResponseBody
    public Order createNewOrderFromCart(@RequestBody ShoppingCart shoppingCart) {
        return orderService.createOrderFromCart(shoppingCart);
    }

    @Override
    @RequestMapping(value = "/placeorder")
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }


    @Override
    @RequestMapping(value = "/update")
    @ResponseBody
    public void updateOrder(@RequestBody  Order order) {
         orderService.updateOrder(order);
    }

    @Override
    @RequestMapping(value = "/delete")
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }
}
