package com.epam.andriushchenko.web.order;

import com.epam.andriushchenko.entities.orders.Order;
import com.epam.andriushchenko.entities.orders.OrderStatus;
import com.epam.andriushchenko.entities.users.User;
import com.epam.andriushchenko.services.CartService;
import com.epam.andriushchenko.services.OrderService;
import com.epam.andriushchenko.util.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private CartService cartService;

    @Override
    public void init() {
        orderService = (OrderService) getServletContext().getAttribute("orderService");
        cartService = (CartService) getServletContext().getAttribute("cartService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime orderTime = LocalDateTime.now();
        User user = (User) req.getSession().getAttribute("user");
        Order order = new Order(OrderStatus.PROCESS, "", orderTime, user.getId());
        try {
            orderService.addOrder(order, cartService.getCart());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cartService.clearCart();
        req.getRequestDispatcher(Path.MAIN_PAGE).forward(req, resp);
    }
}
