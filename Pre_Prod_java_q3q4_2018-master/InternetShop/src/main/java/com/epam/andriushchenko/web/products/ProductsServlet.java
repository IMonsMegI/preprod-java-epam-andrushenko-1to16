package com.epam.andriushchenko.web.products;

import com.epam.andriushchenko.entities.products.CategoryProduct;
import com.epam.andriushchenko.entities.products.ManufactureProduct;
import com.epam.andriushchenko.entities.products.Product;
import com.epam.andriushchenko.services.ProductService;
import com.epam.andriushchenko.util.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = null;
        List<CategoryProduct> categoryProducts = null;
        List<ManufactureProduct> manufactureProducts = null;
        try {
            products = productService.findAllProducts();
            categoryProducts = productService.findAllCategory();
            manufactureProducts = productService.findAllManufacture();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("products", products);
        req.setAttribute("categoryProducts", categoryProducts);
        req.setAttribute("manufactureProducts", manufactureProducts);

        req.getRequestDispatcher(Path.PRODUCTS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
