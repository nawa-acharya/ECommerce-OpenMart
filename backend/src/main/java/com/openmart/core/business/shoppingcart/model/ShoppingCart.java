package com.openmart.core.business.shoppingcart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Endalkachew on 10-Jul-16.
 */
@Entity
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartLine> cartLines;

    public ShoppingCart(){
    }

    public ShoppingCart(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void addToCartLine(CartLine cartLine){
        if(!cartLines.contains(cartLine)) {
            cartLines.add(cartLine);
        }
    }

    public void updateCartLine(CartLine cartLine){
        if(cartLines.contains(cartLine)) {
            cartLines.remove(cartLine);
            cartLines.add(cartLine);
        }
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    public void removeItemFromCart(CartLine cartLine){
        this.cartLines.remove(cartLine);
    }


}
