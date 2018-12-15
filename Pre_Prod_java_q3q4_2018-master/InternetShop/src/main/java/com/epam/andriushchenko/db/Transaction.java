package com.epam.andriushchenko.db;

import java.sql.SQLException;

public interface Transaction<T> {
    T execute() throws SQLException;
}
