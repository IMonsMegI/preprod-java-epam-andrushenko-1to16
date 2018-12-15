package com.epam.andriushchenko.services;

import com.epam.andriushchenko.dao.ProductsDAO;
import com.epam.andriushchenko.db.TransactionManager;
import com.epam.andriushchenko.entities.products.CategoryProduct;
import com.epam.andriushchenko.entities.products.ManufactureProduct;
import com.epam.andriushchenko.entities.products.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductsDAO productsDAO;
    private TransactionManager transactionManager;

    public ProductService(ProductsDAO productsDAO, TransactionManager transactionManager) {
        this.productsDAO = productsDAO;
        this.transactionManager = transactionManager;
    }

    public List<Product> findAllProducts() throws SQLException {
        return transactionManager.execute(() -> productsDAO.findAllProducts());
    }

    public List<CategoryProduct> findAllCategory() throws SQLException {
        return transactionManager.execute(() -> productsDAO.findAllCategory());
    }

    public List<ManufactureProduct> findAllManufacture() throws SQLException {
        return transactionManager.execute(() -> productsDAO.findAllManufacture());
    }

    public List<Product> findProductsByFilter(String filterQuery, List<String> filterValues) throws SQLException {
        return transactionManager.execute(() -> productsDAO.findProductsByFilter(filterQuery, filterValues));
    }

    public int getCountOfProducts(String filterQuery, List<String> filterValues) throws SQLException {
        return transactionManager.execute(() -> productsDAO.getCountOfProducts(filterQuery, filterValues));
    }

    public Product getProductById(int id) throws SQLException {
        return transactionManager.execute(() -> productsDAO.findProductById(id));
    }
}