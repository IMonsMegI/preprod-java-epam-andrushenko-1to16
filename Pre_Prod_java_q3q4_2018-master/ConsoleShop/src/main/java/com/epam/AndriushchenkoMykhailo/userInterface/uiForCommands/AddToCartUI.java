package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class AddToCartUI {
    public void infoProductAddedToCart() {
        System.out.println("Product added to cart.");
        System.out.println();
        Util.writeUserMenu();
    }

    public Map<String, Integer> getDataFromUser() {
        Map<String, Integer> data = new HashMap<>();
        System.out.println("Input number of product: ");
        int idProduct = Util.getIntFromUser();
        System.out.println("Input count of products: ");
        int countOfProduct = Util.getIntFromUser();
        data.put("idProduct", idProduct);
        data.put("countOfProduct", countOfProduct);
        return data;
    }
}
