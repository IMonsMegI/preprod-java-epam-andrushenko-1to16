package com.epam.AndriushchenkoMykhailo.dao.services;

import com.epam.AndriushchenkoMykhailo.dao.dao.CartHistoryDAO;
import com.epam.AndriushchenkoMykhailo.entities.CartHistoryProduct;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.util.List;

public class CartHistoryService {
    private CartHistoryDAO cartHistoryDAO;

    public CartHistoryService(CartHistoryDAO cartHistoryDAO) {
        this.cartHistoryDAO = cartHistoryDAO;
    }

    public List<CartHistoryProduct> getCartHistory() {
        return cartHistoryDAO.getCartHistory();
    }

    public void addProductToCartHistory(Electronics product, int countOfProduct) {
        cartHistoryDAO.addProductToCartHistory(product, countOfProduct);
    }
}
