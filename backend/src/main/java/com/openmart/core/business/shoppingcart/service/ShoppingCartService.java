package com.openmart.core.business.shoppingcart.service;

import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;

import java.util.Collection;


/**
 * Created by Endalkachew on 11-Jul-16.
 */
public interface ShoppingCartService {

    /**
     * Gets a shopping cart by ID
     *
     * @param shoppingCartId
     * @return
     */
    ShoppingCart getShoppingCart(int shoppingCartId);

    /**
     * Adds a product to shopping cart.
     *
     * @param shoppingCart
     * @param cartLine
     */
    ShoppingCart addProductToCart(ShoppingCart shoppingCart, CartLine cartLine);

    /**
     *
     * Updates shopping cart.
     *
     * @param shoppingCart
     * @param cartLine
     */
    ShoppingCart updateCart(ShoppingCart shoppingCart, CartLine cartLine);

    /**
     * Removes product from shopping cart.
     *
     * @param shoppingCart
     * @param cartLine
     */
    ShoppingCart removeProductFromCart(ShoppingCart shoppingCart, CartLine cartLine);

    /**
     * Returns coollection of items in the shopping cart.
     *
     * @param shoppingCart
     * @return
     */
    Collection<CartLine> getCartItems(ShoppingCart shoppingCart);
}
