package com.openmart.core.business.shoppingcart.service;

import com.openmart.core.business.order.dao.OrderDao;
import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.model.OrderLine;
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

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart getShoppingCart(int shoppingCartId) {
        return shoppingCartDao.getShoppingCart(shoppingCartId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart addProductToCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.addToCartLine(cartLine);
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart updateCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.updateCartLine(cartLine);
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart removeProductFromCart(ShoppingCart shoppingCart, CartLine cartLine) {
        shoppingCart.removeItemFromCart(cartLine);
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CartLine> getCartItems(ShoppingCart shoppingCart) {
        return shoppingCart.getCartLines();
    }
}
