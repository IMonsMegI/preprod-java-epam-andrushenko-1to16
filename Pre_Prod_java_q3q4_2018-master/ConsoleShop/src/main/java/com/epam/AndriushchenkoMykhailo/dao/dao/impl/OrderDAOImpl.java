package com.epam.AndriushchenkoMykhailo.dao.dao.impl;

import com.epam.AndriushchenkoMykhailo.dao.dao.OrderDAO;
import com.epam.AndriushchenkoMykhailo.entities.Order;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OrderDAOImpl implements OrderDAO {
    private NavigableMap<LocalDateTime, List<Electronics>> orders = new TreeMap<>();

    @Override
    public void addOrder(LocalDateTime date, List<Electronics> orderProducts) {
        orders.put(date, orderProducts);
    }

    @Override
    public List<Order> getOrdersFromTimeInterval(LocalDateTime beforeDate, LocalDateTime afterDate) {
        return orders
                .entrySet()
                .stream()
                .filter(entry -> (beforeDate.isBefore(entry.getKey()) && afterDate.isAfter(entry.getKey())) ||
                        (beforeDate.isAfter(entry.getKey()) && afterDate.isBefore(entry.getKey())))
                .map(entry -> new Order(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Order getNearestOrderToDate(LocalDateTime nearestDate) {
        Map.Entry<LocalDateTime, List<Electronics>> before = orders.floorEntry(nearestDate);
        Map.Entry<LocalDateTime, List<Electronics>> after = orders.ceilingEntry(nearestDate);
        if (before == null && after == null) {
            return null;
        }
        if (before == null) {
            return new Order(after.getKey(), after.getValue());
        }
        if (after == null) {
            return new Order(before.getKey(), before.getValue());
        }
        return (ChronoUnit.SECONDS.between(before.getKey(), nearestDate) < ChronoUnit.SECONDS.between(after.getKey(), nearestDate)) ?
                new Order(before.getKey(), before.getValue()) : new Order(after.getKey(), after.getValue());
    }
}