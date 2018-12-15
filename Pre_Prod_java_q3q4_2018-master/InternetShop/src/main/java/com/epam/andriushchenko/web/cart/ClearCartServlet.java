package com.epam.andriushchenko.web.cart;

import com.epam.andriushchenko.services.CartService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/clearCart")
public class ClearCartServlet extends HttpServlet {
    private CartService cartService;

    @Override
    public void init() throws ServletException {
        cartService = (CartService) getServletContext().getAttribute("cartService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cartService.clearCart();
        BigDecimal summaryCost = cartService.getSummaryCostOfProducts();
        int summaryCount = cartService.getSummaryCountOfProducts();

        JSONObject dataJSON = new JSONObject();
        dataJSON.put("summaryCost", summaryCost);
        dataJSON.put("summaryCount", summaryCount);

        resp.setContentType("application/x-json");
        resp.getWriter().print(dataJSON);
    }
}
