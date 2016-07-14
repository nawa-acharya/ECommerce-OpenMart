package com.openmart.core.business.order.service;

import com.openmart.core.business.Payment.service.PaymentService;
//import com.openmart.core.business.order.dao.OrderDao;
import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.model.OrderLine;
import com.openmart.core.business.order.model.OrderStatus;
import com.openmart.core.business.order.util.OrderConfirmationFacade;
import com.openmart.core.business.order.util.OrderException;
import com.openmart.core.business.product.model.Product;
import com.openmart.core.business.product.service.ProductService;
import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired
   // private OrderDao orderDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderConfirmationFacade orderConfirmationFacade;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrderFromCart(User user, ShoppingCart shoppingCart) {
        Order order = new Order();
        List<OrderLine> orderLines = new ArrayList<>();
        List<CartLine> cartLines = shoppingCart.getCartLines();
        for(CartLine cartLine : cartLines){
            orderLines.add(new OrderLine(cartLine.getProduct(), cartLine.getQuantity()));
        }
        order.setTotalPrice(getTotalPrice(orderLines));
        order.setOrderLines(orderLines);

        user.addOrder(order);
        userService.updateUser(user);

        return order;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order createOrder(User user, Order order) throws OrderException {
       List<OrderLine> orderLines = order.getOrderLines();

        for(OrderLine orderLine: orderLines){
            Product product = productService.getById(orderLine.getProduct().getId());
            if(product == null){
                throw new OrderException("Product not found");
            }
            if(orderLine.getQuantity() > product.getProductCatalog().getQuantity()){
                throw new OrderException("Requested quantity or product is not available");
            }

            orderLine.setProduct(product);
        }

        double totalPrice = getTotalPrice(orderLines);
        order.setTotalPrice(totalPrice);
        if(paymentService.processPayment(totalPrice)){
            productService.updateCatalog(orderLines);

            order.setOrderStatus(OrderStatus.COMPLETED);
            order.setOrderDate(new Date());
            order.setExpectedDeliveryDate(getDemoDeliveryDate(order.getOrderDate()));

            user.addOrder(order);
            userService.updateUser(user);
            userService.getAllUsers();

            orderConfirmationFacade.sendConfirmationEmail(user.getUsername(), order);

        } else{
            order.setOrderStatus(OrderStatus.PAYMENT_FAILED);
        }
        return order;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrder(User user, Order order) {
        if(user.removeOrder(order)){
            user.addOrder(order);
            userService.updateUser(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOrder(User user, Order order) {
        if(user.removeOrder(order)){
            userService.updateUser(user);
        }
    }

    private double getTotalPrice(List<OrderLine> orderLines){
        double totalPrice = 0.0;
        for(OrderLine orderLine : orderLines){
            totalPrice += orderLine.getProduct().getPrice() * orderLine.getQuantity();
        }
        return totalPrice;
    }

    private Date getDemoDeliveryDate(Date orderDate){
        return new Date(orderDate.getTime() +  1000 * 60 * 60 * 24 * 7);
    }

}
