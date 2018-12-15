package com.epam.AndriushchenkoMykhailo.dao.dao.impl;

import com.epam.AndriushchenkoMykhailo.dao.dao.CartDAO;
import com.epam.AndriushchenkoMykhailo.entities.CartProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartDAOImpl implements CartDAO {
    private Map<Integer, Integer> cart = new HashMap<>();

    @Override
    public List<CartProduct> getCart() {
        return cart.entrySet().stream()
                .map(entry -> new CartProduct(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

    }

    @Override
    public void addProductToCart(int id, int countOfProduct) {
        Integer oldValue = cart.putIfAbsent(id, countOfProduct);
        if (oldValue != null) {
            cart.put(id, oldValue + countOfProduct);
        }
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}
