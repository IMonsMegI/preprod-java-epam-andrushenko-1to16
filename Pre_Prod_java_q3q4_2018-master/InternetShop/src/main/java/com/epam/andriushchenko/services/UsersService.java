package com.epam.andriushchenko.services;

import com.epam.andriushchenko.dao.UsersDAO;
import com.epam.andriushchenko.db.TransactionManager;
import com.epam.andriushchenko.entities.users.User;

import java.sql.SQLException;

public class UsersService {
    private UsersDAO usersDAO;
    private TransactionManager transactionManager;

    public UsersService(UsersDAO usersDAO, TransactionManager transactionManager) {
        this.usersDAO = usersDAO;
        this.transactionManager = transactionManager;
    }

    public boolean isExistUser(String login) throws SQLException {
        return transactionManager.execute(() -> usersDAO.isExistUser(login));
    }

    public boolean addUser(User user) throws SQLException {
        return transactionManager.execute(() -> usersDAO.addUser(user));
    }

    public User findUserByLogin(String login) throws SQLException {
        return transactionManager.execute(() -> usersDAO.findUserByLogin(login));
    }
}
