package com.epam.andriushchenko.entities.orders;

public enum OrderStatus {
    ACCEPTED,
    CONFIRMED,
    PROCESS,
    EXILED,
    CLOSED,
    CANCELED;

    public static OrderStatus getOrderStatus(int idOrderStatus) {
        return OrderStatus.values()[idOrderStatus];
    }
}

