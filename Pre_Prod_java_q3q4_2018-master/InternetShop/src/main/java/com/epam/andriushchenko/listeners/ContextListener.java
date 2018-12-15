package com.epam.andriushchenko.listeners;

import com.epam.andriushchenko.dao.CartDAO;
import com.epam.andriushchenko.dao.OrderDAO;
import com.epam.andriushchenko.dao.ProductsDAO;
import com.epam.andriushchenko.dao.UsersDAO;
import com.epam.andriushchenko.dao.impl.CartDAOImpl;
import com.epam.andriushchenko.dao.impl.OrderDAOImpl;
import com.epam.andriushchenko.dao.impl.ProductsDAOImpl;
import com.epam.andriushchenko.dao.impl.UsersDAOImpl;
import com.epam.andriushchenko.db.DBManager;
import com.epam.andriushchenko.db.TransactionManager;
import com.epam.andriushchenko.services.CartService;
import com.epam.andriushchenko.services.OrderService;
import com.epam.andriushchenko.services.ProductService;
import com.epam.andriushchenko.services.UsersService;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String imageDirectory = "usersImages";
        DBManager dbManager = null;
        try {
            dbManager = new DBManager();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        UsersDAO usersDAO = new UsersDAOImpl();
        ProductsDAO productsDAO = new ProductsDAOImpl();
        CartDAO cartDAO = new CartDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();

        TransactionManager transactionManager = new TransactionManager(dbManager);
        UsersService usersService = new UsersService(usersDAO, transactionManager);
        ProductService productService = new ProductService(productsDAO, transactionManager);
        CartService cartService = new CartService(cartDAO);
        OrderService orderService = new OrderService(orderDAO, transactionManager);

        context.setAttribute("directory", imageDirectory);
        context.setAttribute("usersService", usersService);
        context.setAttribute("productService", productService);
        context.setAttribute("cartService", cartService);
        context.setAttribute("orderService", orderService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}
