package com.epam.andriushchenko.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    private DBManager dbManager;

    public TransactionManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public <T> T execute(Transaction<T> transaction) throws SQLException {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            connection.setAutoCommit(false);
            ConnectionHolder.setConnection(connection);
            T value = transaction.execute();
            connection.commit();
            return value;
        } catch (SQLException e) {
            rollback(connection);
            throw new SQLException(e);
        } finally {
            ConnectionHolder.setConnection(null);
            close(connection);
        }
    }

    private void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
