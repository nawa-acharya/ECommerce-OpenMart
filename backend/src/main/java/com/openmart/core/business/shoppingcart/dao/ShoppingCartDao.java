package com.openmart.core.business.shoppingcart.dao;

import com.openmart.core.business.shoppingcart.model.ShoppingCart;

/**
 * Created by Endalkachew on 11-Jul-16.
 */
public interface ShoppingCartDao {
    void update(ShoppingCart shoppingCart);

    ShoppingCart getShoppingCart(int shoppingCartId);
}
