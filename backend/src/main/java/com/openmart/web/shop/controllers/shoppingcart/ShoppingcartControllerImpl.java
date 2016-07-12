package com.openmart.web.shop.controllers.shoppingcart;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.product.service.ProductService;
import com.openmart.core.business.shoppingcart.model.*;
import com.openmart.core.business.shoppingcart.service.ShoppingCartService;
import com.openmart.core.business.user.model.User;
import com.openmart.web.shop.controllers.shoppingcart.facade.ShoppingCartController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sandip on 7/3/16.
 */
@Controller
@RequestMapping(value = "rest/shoppingcart")
public class ShoppingCartControllerImpl implements ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCart addItemToCart(@RequestBody CartLine cartLine, HttpServletRequest httpServletRequest) {
        // TODO can be changed to get user from spring security
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
          //  ShoppingCart shoppingCart =  user.getShoppingCart();
          //  return shoppingCartService.addProductToCart(shoppingCart, cartLine);
        }
        return null;
    }

    @RequestMapping(value = "/removeitem", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCart removeItemFromCart(@RequestBody CartLine cartLine, HttpServletRequest request) {
        // TODO can be changed to get user from spring security
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
         //  ShoppingCart shoppingCart = user.getShoppingCart();
          //  return shoppingCartService.removeProductFromCart(shoppingCart, cartLine);
        }
        return null;
    }

    @RequestMapping(value="/updateitem", method = RequestMethod.POST)
    @ResponseBody
    public ShoppingCart updateCartItem(@RequestBody CartLine cartLine, HttpServletRequest request){
        // TODO can be changed to get user from spring security
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
          //  ShoppingCart shoppingCart = user.getShoppingCart();
          //  return shoppingCartService.updateCart(shoppingCart, cartLine);
        }
        return null;
    }
}
