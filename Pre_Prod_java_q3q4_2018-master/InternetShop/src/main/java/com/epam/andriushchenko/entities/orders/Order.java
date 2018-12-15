package com.epam.andriushchenko.entities.orders;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private OrderStatus orderStatus;
    private String descriptionOfStatus;
    private LocalDateTime timeOfOrder;
    private int idUser;
    private List<OrderProductInfo> orderProducts;

    public Order(OrderStatus orderStatus, String descriptionOfStatus, LocalDateTime timeOfOrder, int idUser) {
        this.orderStatus = orderStatus;
        this.descriptionOfStatus = descriptionOfStatus;
        this.timeOfOrder = timeOfOrder;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDescriptionOfStatus() {
        return descriptionOfStatus;
    }

    public void setDescriptionOfStatus(String descriptionOfStatus) {
        this.descriptionOfStatus = descriptionOfStatus;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(LocalDateTime timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<OrderProductInfo> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductInfo> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
