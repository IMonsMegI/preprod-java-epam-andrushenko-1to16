package com.epam.AndriushchenkoMykhailo.dao.services;

import com.epam.AndriushchenkoMykhailo.dao.dao.CartDAO;
import com.epam.AndriushchenkoMykhailo.entities.CartProduct;

import java.util.List;

public class CartService {
    private CartDAO cartDAO;

    public CartService(CartDAO cart) {
        this.cartDAO = cart;
    }

    public List<CartProduct> getCart() {
        return cartDAO.getCart();
    }

    public void addProductToCart(int id, int countOfProduct) {
        cartDAO.addProductToCart(id, countOfProduct);
    }

    public void clearCart() {
        cartDAO.clearCart();
    }
}
