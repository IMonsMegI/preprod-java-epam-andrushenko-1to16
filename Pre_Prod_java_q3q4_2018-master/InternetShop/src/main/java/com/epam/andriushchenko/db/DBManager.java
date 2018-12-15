package com.epam.andriushchenko.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBManager {
    private DataSource mds;

    public DBManager() throws NamingException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Context initContext = new InitialContext();
        mds = (DataSource) initContext.lookup("java:/comp/env/jdbc/internettvshop");
    }

    public Connection getConnection() {
        try {
            return mds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
