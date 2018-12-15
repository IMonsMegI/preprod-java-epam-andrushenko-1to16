package com.epam.andriushchenko.entities.users;

public enum UserRole {
    ADMIN,
    USER;

    public static UserRole getOrderStatus(int idRole) {
        return UserRole.values()[idRole];
    }
}
