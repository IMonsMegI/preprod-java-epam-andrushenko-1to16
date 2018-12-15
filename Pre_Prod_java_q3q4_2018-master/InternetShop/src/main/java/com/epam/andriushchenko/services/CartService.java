package com.epam.andriushchenko.services;

import com.epam.andriushchenko.dao.CartDAO;
import com.epam.andriushchenko.entities.products.Product;

import java.math.BigDecimal;
import java.util.Map;

public class CartService {
    private CartDAO cartDAO;

    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public Map<Product, Integer> getCart() {
        return cartDAO.getCart();
    }

    public boolean addProductToCart(Product product, Integer count) {
        return cartDAO.addProductToCart(product, count);
    }

    public void deleteProductFromCart(Product product) {
        cartDAO.deleteProductFromCart(product);
    }

    public BigDecimal getSummaryCostOfProducts() {
        return cartDAO.getSummaryCostOfProducts();
    }

    public int getSummaryCountOfProducts() {
        return cartDAO.getSummaryCountOfProducts();
    }

    public void clearCart() {
        cartDAO.clearCart();
    }

    public void minusCountItem(Product product) {
        cartDAO.minusCountItem(product);
    }

    public void plusCountItem(Product product) {
        cartDAO.plusCountItem(product);
    }
}
