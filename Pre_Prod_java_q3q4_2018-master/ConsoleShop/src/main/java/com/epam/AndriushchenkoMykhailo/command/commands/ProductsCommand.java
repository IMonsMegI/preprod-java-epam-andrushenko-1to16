package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.ProductsService;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.ProductsUI;

import java.util.List;

public class ProductsCommand implements Command {
    private ProductsService productsService;
    private ProductsUI productsUI;

    public ProductsCommand(Context context) {
        this.productsService = context.getProductsService();
        this.productsUI = context.getUiContainer().getProductsUI();
    }

    @Override
    public void execute() {
        List<Electronics> productList = productsService.getProducts();
        productsUI.writeProductList(productList);
    }
}
