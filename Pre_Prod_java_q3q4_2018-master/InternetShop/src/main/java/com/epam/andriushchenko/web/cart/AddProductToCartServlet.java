package com.epam.andriushchenko.web.cart;

import com.epam.andriushchenko.entities.products.Product;
import com.epam.andriushchenko.services.CartService;
import com.epam.andriushchenko.services.ProductService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addToCart")
public class AddProductToCartServlet extends HttpServlet {
    private CartService cartService;
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        cartService = (CartService) getServletContext().getAttribute("cartService");
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Product product = null;
        try {
            product = productService.getProductById(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cartService.addProductToCart(product, 1);

        int summaryCount = cartService.getSummaryCountOfProducts();
        JSONObject dataJSON = new JSONObject();
        dataJSON.put("summaryCount", summaryCount);

        resp.setContentType("application/x-json");
        resp.getWriter().print(dataJSON);
    }
}
