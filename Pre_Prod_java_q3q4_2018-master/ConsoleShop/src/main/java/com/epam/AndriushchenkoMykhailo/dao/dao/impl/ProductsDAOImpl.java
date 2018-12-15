package com.epam.AndriushchenkoMykhailo.dao.dao.impl;

import com.epam.AndriushchenkoMykhailo.dao.dao.ProductsDAO;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.serialization.json.JsonWriter;

import java.util.ArrayList;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    private List<Electronics> productList = new ArrayList<>();
    private int idIncrementator;

    public ProductsDAOImpl(List<Electronics> initList) {
        productList.addAll(initList);
    }

    public void setIdIncrementator(int idIncrementator) {
        this.idIncrementator = idIncrementator;
    }

    @Override
    public List<Electronics> getProductList() {
        return productList;
    }

    @Override
    public Electronics getProductById(int id) {
        Electronics electronics = productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
        if (electronics == null) {
            throw new IllegalArgumentException();
        }
        return electronics;
    }

    @Override
    public void addProduct(Electronics product) {
        product.setId(idIncrementator++);
        productList.add(product);
    }

    @Override
    public void saveProductsToJson() {
        JsonWriter.writeProductListToJson(productList);
    }
}
