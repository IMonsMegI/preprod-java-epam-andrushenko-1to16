package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.entities.orders.Order;
import com.epam.andriushchenko.entities.products.Product;

import java.util.Map;

public interface OrderDAO {
    boolean addOrder(Order order, Map<Product, Integer> cart);
}
