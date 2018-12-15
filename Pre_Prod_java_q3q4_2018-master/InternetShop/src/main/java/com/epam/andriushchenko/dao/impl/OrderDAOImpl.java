package com.epam.andriushchenko.dao.impl;

import com.epam.andriushchenko.dao.OrderDAO;
import com.epam.andriushchenko.db.ConnectionHolder;
import com.epam.andriushchenko.entities.orders.Order;
import com.epam.andriushchenko.entities.orders.OrderProductInfo;
import com.epam.andriushchenko.entities.products.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {
    private static final String ADD_ORDER = "INSERT INTO orders (id_status,descriptionOfStatus,date,id_user) VALUES (?,?,?,?)";
    private static final String ADD_ORDER_PRODUCT_INFO = "INSERT INTO order_product_info (id_order,id_product,count,cost) VALUES (?,?,?,?)";

    @Override
    public boolean addOrder(Order order, Map<Product, Integer> cart) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order.getOrderStatus().ordinal());
            pstmt.setString(2, order.getDescriptionOfStatus());
            pstmt.setObject(3, order.getTimeOfOrder());
            pstmt.setInt(4, order.getIdUser());
            int update = pstmt.executeUpdate();
            if (update <= 0)
                throw new SQLException();
            rs = pstmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            getListOfProductsInCart(id, cart).forEach(this::addOrderProductInfo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            close(rs);
            close(pstmt);
        }
        return true;
    }

    private List<OrderProductInfo> getListOfProductsInCart(int id, Map<Product, Integer> cart) {
        List<OrderProductInfo> orderProducts = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            orderProducts.add(new OrderProductInfo(id, entry.getKey(), entry.getValue(), entry.getKey().getCost()));
        }
        return orderProducts;
    }

    private void addOrderProductInfo(OrderProductInfo orderProductInfo) {
        PreparedStatement pstmt = null;
        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(ADD_ORDER_PRODUCT_INFO);
            pstmt.setInt(1, orderProductInfo.getIdOrder());
            pstmt.setInt(2, orderProductInfo.getProduct().getId());
            pstmt.setInt(3, orderProductInfo.getCountOfProduct());
            pstmt.setObject(4, orderProductInfo.getCost());
            int update = pstmt.executeUpdate();
            if (update <= 0)
                throw new SQLException();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(pstmt);
        }
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
