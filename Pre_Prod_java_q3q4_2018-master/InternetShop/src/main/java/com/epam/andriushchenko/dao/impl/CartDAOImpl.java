package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.CartDAO;
import com.epam.andriushchenko.entities.products.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartDAOImpl implements CartDAO {
    private Map<Product, Integer> cart = new HashMap<>();

    @Override
    public Map<Product, Integer> getCart() {
        return cart;
    }

    @Override
    public boolean addProductToCart(Product product, Integer count) {
        if (product != null) {
            Integer oldValue = cart.putIfAbsent(product, count);
            if (oldValue != null) {
                cart.put(product, oldValue + count);
            }
            return true;
        }
        return false;
    }

    @Override
    public void deleteProductFromCart(Product product) {
        cart.remove(product);
    }

    @Override
    public BigDecimal getSummaryCostOfProducts() {
        BigDecimal summaryCost = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            summaryCost = summaryCost.add(entry.getKey().getCost().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return summaryCost;
    }

    @Override
    public int getSummaryCountOfProducts() {
        int summaryCount = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            summaryCount += entry.getValue();
        }
        return summaryCount;
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    @Override
    public void minusCountItem(Product product) {
        int value = cart.get(product);
        value--;
        if (value < 0) {
            value = 0;
        }
        cart.put(product, value);
    }

    @Override
    public void plusCountItem(Product product) {
        int value = cart.get(product);
        cart.put(product, ++value);
    }
}
