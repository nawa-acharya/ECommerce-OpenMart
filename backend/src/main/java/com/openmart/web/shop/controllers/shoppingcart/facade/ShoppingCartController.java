package com.openmart.web.shop.controllers.shoppingcart.facade;

import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
public interface ShoppingCartController {

    ShoppingCart addItemToCart(CartLine cartLine, HttpServletRequest httpServletRequest);

    ShoppingCart removeItemFromCart(CartLine cartLine, HttpServletRequest request);

    ShoppingCart updateCartItem(@RequestBody CartLine cartLine, HttpServletRequest request);

}
