package com.epam.AndriushchenkoMykhailo.dao.dao;

import com.epam.AndriushchenkoMykhailo.entities.CartHistoryProduct;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.util.List;

public interface CartHistoryDAO {
    List<CartHistoryProduct> getCartHistory();

    void addProductToCartHistory(Electronics product, int countOfProduct);
}
