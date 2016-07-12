package com.openmart.web.shop.controllers.order;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.service.OrderService;
import com.openmart.core.business.order.util.OrderException;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import com.openmart.core.utils.SpringSecurityHelper;
import com.openmart.web.shop.controllers.order.facade.OrderController;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Controller
@RequestMapping(value = "openmart/api/order")
public class OrderControllerImpl implements OrderController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private SpringSecurityHelper securityHelper;


    @Override
    @RequestMapping(value = "/createfromcart", method = RequestMethod.POST)
    public @ResponseBody Order createNewOrderFromCart(@RequestBody ShoppingCart shoppingCart, HttpServletRequest request) {
        User user = securityHelper.getCurrentUserFromSession(request);
        if(user != null){
            return orderService.createOrderFromCart(user, shoppingCart);
        }
        return null;
    }

    @Override
    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    public @ResponseBody Order createOrder(@RequestBody Order order, HttpServletRequest request) {
        User user = securityHelper.getCurrentUserFromSession(request);
        //TODO remove
        user = securityHelper.getDemoUser();
        if(user != null){
            try{
               return  orderService.createOrder(user, order);
            }catch (OrderException ex){
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }


    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrder(@RequestBody  Order order, HttpServletRequest request) {
        User user = securityHelper.getCurrentUserFromSession(request);
        if(user != null){
            try{
                orderService.updateOrder(user, order);
            }catch (OrderException ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(Order order, HttpServletRequest request) {
        User user = securityHelper.getCurrentUserFromSession(request);
        if(user != null) {
            orderService.deleteOrder(user, order);
        }
    }

    @Override
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Order> getOrders(HttpServletRequest request) {
        User user = securityHelper.getCurrentUserFromSession(request);
        user = securityHelper.getDemoUser();
        if(user != null){
            return user.getOrders();
        }
        return null;
    }
}
