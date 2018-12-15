package com.epam.andriushchenko.dao;

import com.epam.andriushchenko.entities.products.CategoryProduct;
import com.epam.andriushchenko.entities.products.ManufactureProduct;
import com.epam.andriushchenko.entities.products.Product;

import java.util.List;

public interface ProductsDAO {
    List<Product> findAllProducts();

    List<CategoryProduct> findAllCategory();

    List<ManufactureProduct> findAllManufacture();

    List<Product> findProductsByFilter(String filterQuery, List<String> filterValues);

    int getCountOfProducts(String filterQuery, List<String> filterValues);

    Product findProductById(int id);
}
