package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.util.List;

public class ProductsUI {
    public void writeProductList(List<Electronics> products) {
        products.forEach(product -> System.out.println(product.getId() + ". " + product.toString()));
        System.out.println();
        Util.writeUserMenu();
    }

}
