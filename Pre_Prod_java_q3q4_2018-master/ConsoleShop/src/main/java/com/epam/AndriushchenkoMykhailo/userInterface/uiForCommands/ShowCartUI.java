package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.CartProduct;

import java.util.List;

public class ShowCartUI {
    public void writeCart(List<CartProduct> cart) {
        if (!cart.isEmpty()) {
            cart.forEach((cartProduct) -> System.out.println(cartProduct.getId() + " - " + cartProduct.getCountOfProduct()));
            System.out.println();
            Util.writeUserMenu();
        } else {
            System.out.println("Cart is empty. Add product!");
        }
    }
}
