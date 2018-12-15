package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.entities.users.User;

public interface UsersDAO {
    boolean isExistUser(String login);

    boolean addUser(User user);

    User findUserByLogin(String login);
}
