package com.epam.AndriushchenkoMykhailo.entities;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime localDateTime;
    private List<Electronics> products;

    public Order(LocalDateTime localDateTime, List<Electronics> products) {
        this.localDateTime = localDateTime;
        this.products = products;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public List<Electronics> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" + "localDateTime=" + localDateTime + ", products=" + products + '}';
    }
}
