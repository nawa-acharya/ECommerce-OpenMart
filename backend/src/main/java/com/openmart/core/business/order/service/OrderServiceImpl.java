package com.openmart.core.business.order.service;

import com.openmart.core.business.Payment.model.PaymentStatus;
import com.openmart.core.business.Payment.service.PaymentService;
import com.openmart.core.business.order.dao.OrderDao;
import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.model.OrderLine;
import com.openmart.core.business.order.model.OrderStatus;
import com.openmart.core.business.shoppingcart.model.Address;
import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ProductService;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrderFromCart(ShoppingCart shoppingCart) {
        Order order = new Order();
        List<OrderLine> orderLines = new ArrayList<>();
        List<CartLine> cartLines = shoppingCart.getCartLines();
        for(CartLine cartLine : cartLines){
            orderLines.add(new OrderLine(cartLine.getProduct(), cartLine.getQuantity()));
        }
        order.setTotalPrice(getTotalPrice(orderLines));
        order.setOrderLines(orderLines);
        return orderDao.saveOrder(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrder(Order order) {
       List<OrderLine> orderLines = order.getOrderLines();
        double totalPrice = getTotalPrice(orderLines);
        order.setTotalPrice(totalPrice);
        if(paymentService.processPayment(totalPrice)){
            productService.updateCatalog(orderLines);
            order.setOrderStatus(OrderStatus.COMPLETED);
            orderDao.saveOrder(order);
        } else{
            order.setOrderStatus(OrderStatus.PAYMENT_FAILED);
        }
        return order;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    private double getTotalPrice(List<OrderLine> orderLines){
        double totalPrice = 0.0;
        for(OrderLine orderLine : orderLines){
            totalPrice += orderLine.getProduct().getPrice();
        }
        return totalPrice;
    }
}
