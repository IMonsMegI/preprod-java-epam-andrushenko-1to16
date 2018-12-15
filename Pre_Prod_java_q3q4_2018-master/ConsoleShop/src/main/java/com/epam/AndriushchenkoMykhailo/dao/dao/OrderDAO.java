package com.epam.AndriushchenkoMykhailo.dao.dao;

import com.epam.AndriushchenkoMykhailo.entities.Order;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDAO {

    void addOrder(LocalDateTime date, List<Electronics> orderProducts);

    List<Order> getOrdersFromTimeInterval(LocalDateTime before, LocalDateTime after);

    Order getNearestOrderToDate(LocalDateTime nearestDate);
}
