package com.epam.AndriushchenkoMykhailo.dao.dao;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.util.List;

public interface ProductsDAO {
    List<Electronics> getProductList();

    Electronics getProductById(int id);

    void addProduct(Electronics product);

    void saveProductsToJson();

    void setIdIncrementator(int idIncrementator);
}
