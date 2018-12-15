package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.CartHistoryService;
import com.epam.AndriushchenkoMykhailo.dao.services.CartService;
import com.epam.AndriushchenkoMykhailo.dao.services.ProductsService;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.AddToCartUI;

import java.util.Map;

public class AddToCartCommand implements Command {
    private static final String ID_PRODUCT = "idProduct";
    private static final String COUNT_OF_PRODUCT = "countOfProduct";
    private AddToCartUI addToCartUI;
    private CartService cartService;
    private CartHistoryService cartHistoryService;
    private ProductsService productsService;

    public AddToCartCommand(Context context) {
        this.addToCartUI = context.getUiContainer().getAddToCartUI();
        this.cartService = context.getCartService();
        this.cartHistoryService = context.getCartHistoryService();
        this.productsService = context.getProductsService();
    }

    @Override
    public void execute() {
        Map<String, Integer> data = addToCartUI.getDataFromUser();
        cartService.addProductToCart(data.get(ID_PRODUCT), data.get(COUNT_OF_PRODUCT));
        Electronics electronics = productsService.getProductById(data.get(ID_PRODUCT));
        cartHistoryService.addProductToCartHistory(electronics, data.get(COUNT_OF_PRODUCT));
        addToCartUI.infoProductAddedToCart();
    }
}
