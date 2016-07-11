package com.openmart.core.business.shoppingcart.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<CartLine, CartLine> cartLines;

    public ShoppingCart(){
    }

    public ShoppingCart(User user, Map<CartLine, CartLine> cartLines) {
        this.user = user;
        this.cartLines = cartLines;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<CartLine, CartLine> getCartLines() {
        return cartLines;
    }

    public void addToCartLine(CartLine cartLine){
        cartLines.put(cartLine, cartLine);
    }

    public void setCartLines(Map<CartLine, CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    public void removeItemFromCart(CartLine cartLine){
        this.cartLines.remove(cartLine);
    }


}
