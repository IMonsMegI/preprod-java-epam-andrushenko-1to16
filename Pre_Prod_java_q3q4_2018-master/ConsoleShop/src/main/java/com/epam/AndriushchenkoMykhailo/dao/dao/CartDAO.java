package com.epam.AndriushchenkoMykhailo.dao.dao;

import com.epam.AndriushchenkoMykhailo.entities.CartProduct;

import java.util.List;

public interface CartDAO {
    List<CartProduct> getCart();

    void addProductToCart(int id, int countOfProduct);

    void clearCart();

}
