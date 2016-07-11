package com.openmart.web.shop.controllers.shoppingcart.facade;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.shoppingcart.model.CartLine;
import com.openmart.core.business.shoppingcart.model.Product;
import com.openmart.core.business.shoppingcart.model.ShoppingCart;
import com.openmart.core.business.shoppingcart.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
public interface ShoppingCartController {

    ShoppingCart addItemToCart(CartLine cartLine, HttpServletRequest httpServletRequest);

    ShoppingCart removeItemFromCart(CartLine cartLine, HttpServletRequest request);

    ShoppingCart updateCartItem(@RequestBody CartLine cartLine, HttpServletRequest request);

}
