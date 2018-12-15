package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.ProductsService;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.inputStrategy.InputStrategyContainer;
import com.epam.AndriushchenkoMykhailo.inputStrategy.InputType;
import com.epam.AndriushchenkoMykhailo.inputStrategy.ProductType;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.AddProductUI;

public class AddProductCommand implements Command {
    private AddProductUI addProductUI;
    private InputStrategyContainer inputStrategyContainer;
    private ProductsService productsService;

    public AddProductCommand(Context context) {
        addProductUI = context.getUiContainer().getAddProductUI();
        inputStrategyContainer = context.getInputStrategyContainer();
        productsService = context.getProductsService();
    }

    @Override
    public void execute() {
        if (addProductUI.getInputType() == null) {
            addProductUI.setInputType(InputType.valueOf(addProductUI.getInputTypeFromUser().toUpperCase()));
        }
        String productType = addProductUI.getProductTypeFromUser();
        Electronics newProduct = inputStrategyContainer.getElectronicConstructor(addProductUI.getInputType(), ProductType.valueOf(productType.toUpperCase())).makeProduct();
        productsService.setIdIncrementator(productsService.getProducts().size());
        if (newProduct != null) {
            productsService.addProduct(newProduct);
            addProductUI.infoNewProductAdded();
        }
    }
}
