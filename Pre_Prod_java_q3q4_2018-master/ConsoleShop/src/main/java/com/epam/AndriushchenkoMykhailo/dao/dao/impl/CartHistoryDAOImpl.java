package com.epam.AndriushchenkoMykhailo.dao.dao.impl;

import com.epam.AndriushchenkoMykhailo.dao.dao.CartHistoryDAO;
import com.epam.AndriushchenkoMykhailo.entities.CartHistoryProduct;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartHistoryDAOImpl implements CartHistoryDAO {
    private Map<Electronics, Integer> cartHistory;

    public CartHistoryDAOImpl(int count) {
        cartHistory = new LinkedHashMap<Electronics, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Electronics, Integer> eldest) {
                return cartHistory.size() > count;
            }
        };
    }

    @Override
    public List<CartHistoryProduct> getCartHistory() {
        return cartHistory
                .entrySet()
                .stream()
                .map(entry -> new CartHistoryProduct(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCartHistory(Electronics product, int countOfProduct) {
        Integer oldValue = cartHistory.putIfAbsent(product, countOfProduct);
        if (oldValue != null) {
            cartHistory.put(product, oldValue + countOfProduct);
        }
    }
}