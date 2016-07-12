package com.openmart.core.business.shoppingcart.service;


import com.openmart.core.business.shoppingcart.dao.ShoppingCartDao;
import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart getShoppingCart(int shoppingCartId) {
        return shoppingCartDao.getShoppingCart(shoppingCartId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart addProductToCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.addToCartLine(cartLine);
        shoppingCart.setTotalPrice(getTotalPrice(shoppingCart.getCartLines()));
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart updateCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.updateCartLine(cartLine);
        shoppingCart.setTotalPrice(getTotalPrice(shoppingCart.getCartLines()));
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart removeProductFromCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.removeItemFromCart(cartLine);
        shoppingCart.setTotalPrice(getTotalPrice(shoppingCart.getCartLines()));
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CartLine> getCartItems(ShoppingCart shoppingCart) {
        return shoppingCart.getCartLines();
    }

    private double getTotalPrice(List<CartLine> cartLines){
        double totalPrice = 0.0;
        for(CartLine cartLine : cartLines){
            totalPrice += cartLine.getProduct().getPrice() * cartLine.getQuantity();
        }
        return totalPrice;
    }
}
