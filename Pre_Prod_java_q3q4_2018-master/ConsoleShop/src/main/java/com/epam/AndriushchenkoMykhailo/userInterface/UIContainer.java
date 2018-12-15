package com.epam.AndriushchenkoMykhailo.userInterface;

import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.*;

public class UIContainer {
    private ProductsUI productsUI = new ProductsUI();
    private ShowCartUI showCartUI = new ShowCartUI();
    private OrderFromTimeIntervalUI orderFromTimeIntervalUI = new OrderFromTimeIntervalUI();
    private NearestOrderByDateUI nearestOrderByDateUI = new NearestOrderByDateUI();
    private MakeOrderUI makeOrderUI = new MakeOrderUI();
    private HistoryCartUI historyCartUI = new HistoryCartUI();
    private AddToCartUI addToCartUI = new AddToCartUI();
    private AdminMenuUI adminMenuUI = new AdminMenuUI();
    private UserMenuUI userMenuUI = new UserMenuUI();
    private AddProductUI addProductUI = new AddProductUI();

    public ProductsUI getProductsUI() {
        return productsUI;
    }

    public ShowCartUI getShowCartUI() {
        return showCartUI;
    }

    public OrderFromTimeIntervalUI getOrderFromTimeIntervalUI() {
        return orderFromTimeIntervalUI;
    }

    public NearestOrderByDateUI getNearestOrderByDateUI() {
        return nearestOrderByDateUI;
    }

    public MakeOrderUI getMakeOrderUI() {
        return makeOrderUI;
    }

    public HistoryCartUI getHistoryCartUI() {
        return historyCartUI;
    }

    public AddToCartUI getAddToCartUI() {
        return addToCartUI;
    }

    public AdminMenuUI getAdminMenuUI() {
        return adminMenuUI;
    }

    public UserMenuUI getUserMenuUI() {
        return userMenuUI;
    }

    public AddProductUI getAddProductUI() {
        return addProductUI;
    }
}
