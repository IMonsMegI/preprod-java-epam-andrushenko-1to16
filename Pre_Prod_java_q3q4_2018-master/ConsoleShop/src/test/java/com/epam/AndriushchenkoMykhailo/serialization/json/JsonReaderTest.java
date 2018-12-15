package com.epam.AndriushchenkoMykhailo.serialization.json;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.TV4K;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class JsonReaderTest {
    private List<Electronics> productsExpected;

    @BeforeEach
    void init() {
        productsExpected = initProducts();
    }

    @Test
    void getProductListFromJson() {
        List<Electronics> productsCurrent = JsonReader.getProductListFromJson();

        assertEquals(productsCurrent, productsExpected);
    }

    private List<Electronics> initProducts() {
        List<Electronics> products = new ArrayList<>();
        products.add(new TV4K(0, new BigDecimal(18000), "Samsung Ultra 4k", 115, 43.0, true, 3840, 9.8, 2160, 3840 * 2160, "16:10"));
        return products;
    }
}