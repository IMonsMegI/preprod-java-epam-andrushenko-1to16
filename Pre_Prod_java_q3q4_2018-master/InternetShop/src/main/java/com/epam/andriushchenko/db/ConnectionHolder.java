package com.epam.andriushchenko.db;

import java.sql.Connection;

public class ConnectionHolder {
    private static final ThreadLocal<Connection> threadLocalConnection = new ThreadLocal<>();

    public static Connection getConnection() {
        return threadLocalConnection.get();
    }

    public static void setConnection(Connection connection) {
        threadLocalConnection.set(connection);
    }
}