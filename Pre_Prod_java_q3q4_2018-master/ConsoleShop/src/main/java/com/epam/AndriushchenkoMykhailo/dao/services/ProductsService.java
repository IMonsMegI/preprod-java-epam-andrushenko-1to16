package com.epam.AndriushchenkoMykhailo.dao.services;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.dao.dao.ProductsDAO;

import java.util.List;

public class ProductsService {
    private ProductsDAO productsDAO;

    public ProductsService(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public List<Electronics> getProducts() {
        return productsDAO.getProductList();
    }

    public Electronics getProductById(int id) {
        return productsDAO.getProductById(id);
    }

    public void addProduct(Electronics product) {
        productsDAO.addProduct(product);
    }

    public void saveProductsToJson() {
        productsDAO.saveProductsToJson();
    }

    public void setIdIncrementator(int idIncrementator) {
        productsDAO.setIdIncrementator(idIncrementator);
    }
}