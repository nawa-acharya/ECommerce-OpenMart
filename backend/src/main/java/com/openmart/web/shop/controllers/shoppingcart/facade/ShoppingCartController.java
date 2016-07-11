package com.openmart.web.shop.controllers.shoppingcart.facade;

import com.openmart.core.business.shoppingcart.model.Order;
import com.openmart.core.business.shoppingcart.model.Product;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.shoppingcart.model.User;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
public interface ShoppingCartController {

    ShoppingCart addItemToCart(User user, Product product);

    ShoppingCart removeItemFromCart(User user, Product product);

    Order continueToCheckOut(User user);
}
