package com.epam.andriushchenko.web.cart;

import com.epam.andriushchenko.entities.products.Product;
import com.epam.andriushchenko.services.CartService;
import com.epam.andriushchenko.util.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private CartService cartService;

    @Override
    public void init() {
        cartService = (CartService) getServletContext().getAttribute("cartService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> cart = cartService.getCart();
        BigDecimal summaryCostOfProductsInCart = cartService.getSummaryCostOfProducts();
        int summaryCountOfProducts = cartService.getSummaryCountOfProducts();
        req.setAttribute("cart", cart);
        req.setAttribute("summaryCostOfProductsInCart", summaryCostOfProductsInCart);
        req.setAttribute("summaryCountOfProducts", summaryCountOfProducts);
        req.getRequestDispatcher(Path.CART_PAGE).forward(req, resp);
    }
}
