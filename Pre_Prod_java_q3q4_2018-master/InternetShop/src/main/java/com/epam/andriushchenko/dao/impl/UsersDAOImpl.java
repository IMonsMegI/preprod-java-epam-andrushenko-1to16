package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.UsersDAO;
import com.epam.andriushchenko.db.ConnectionHolder;
import com.epam.andriushchenko.entities.users.User;
import com.epam.andriushchenko.entities.users.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAOImpl implements UsersDAO {
    private static final String FIND_USER_BY_LOGIN = "SELECT * from users where login=?";
    private static final String ADD_USER = "INSERT INTO users (name,surname,login,email,password,image,id_role) VALUES(?,?,?,?,?,?,?)";

    @Override
    public boolean isExistUser(String login) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                u = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return u != null;
    }

    @Override
    public boolean addUser(User user) {
        PreparedStatement pstmt = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(ADD_USER);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getLogin());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getImage());
            pstmt.setInt(7, UserRole.USER.ordinal());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(pstmt);
        }
        return true;
    }

    @Override
    public User findUserByLogin(String login) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User u = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                u = extractUser(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
            close(rs);
        }
        return u;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id_user"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setImage(rs.getString("image"));
        user.setUserRole(UserRole.getOrderStatus(rs.getInt("id_role")));
        return user;
    }

    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
