package com.epam.andriushchenko.services;

import com.epam.andriushchenko.dao.OrderDAO;
import com.epam.andriushchenko.db.TransactionManager;
import com.epam.andriushchenko.entities.orders.Order;
import com.epam.andriushchenko.entities.products.Product;

import java.sql.SQLException;
import java.util.Map;

public class OrderService {
    private OrderDAO orderDAO;
    private TransactionManager transactionManager;

    public OrderService(OrderDAO orderDAO, TransactionManager transactionManager) {
        this.orderDAO = orderDAO;
        this.transactionManager = transactionManager;
    }

    public boolean addOrder(Order order, Map<Product, Integer> cart) throws SQLException {
        return transactionManager.execute(() -> orderDAO.addOrder(order, cart));
    }
}
