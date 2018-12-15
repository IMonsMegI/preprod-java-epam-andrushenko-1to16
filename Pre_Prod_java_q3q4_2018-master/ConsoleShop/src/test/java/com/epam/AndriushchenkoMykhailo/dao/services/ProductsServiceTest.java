package com.epam.AndriushchenkoMykhailo.dao.services;

import com.epam.AndriushchenkoMykhailo.dao.dao.ProductsDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceTest {
    @Mock
    private ProductsDAO productsDAO;
    @InjectMocks
    private ProductsService productsService = new ProductsService(productsDAO);

    @Test
    void getProductList() {
    }

    @Test
    void getProductById() {
    }
}