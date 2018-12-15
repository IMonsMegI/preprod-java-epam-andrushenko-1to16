package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.CartHistoryProduct;

import java.util.List;

public class HistoryCartUI {
    public void writeCartHistory(List<CartHistoryProduct> cartHistory) {
        cartHistory.forEach((cartHistoryProduct) -> System.out.println(cartHistoryProduct.getProduct().getId() + " "
                + cartHistoryProduct.getProduct().getModel() + " - " + cartHistoryProduct.getCountOfProduct()));
        System.out.println();
        Util.writeUserMenu();
    }
}
