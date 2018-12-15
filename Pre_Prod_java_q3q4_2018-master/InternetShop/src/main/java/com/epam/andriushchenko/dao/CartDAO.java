package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.entities.products.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface CartDAO {
    Map<Product, Integer> getCart();

    boolean addProductToCart(Product product, Integer count);

    void deleteProductFromCart(Product product);

    BigDecimal getSummaryCostOfProducts();

    int getSummaryCountOfProducts();

    void clearCart();

    void minusCountItem(Product product);

    void plusCountItem(Product product);

}
