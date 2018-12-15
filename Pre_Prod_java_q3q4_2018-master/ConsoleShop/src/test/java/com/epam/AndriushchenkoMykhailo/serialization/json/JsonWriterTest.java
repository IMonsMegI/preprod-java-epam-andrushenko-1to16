package com.epam.AndriushchenkoMykhailo.serialization.json;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.TV4K;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    private List<Electronics> productsExpected;

    @BeforeEach
    void init() {
        productsExpected = initProducts();
    }

    @Test
    void writeProductListToJson() {
        JsonWriter.writeProductListToJson(new JsonWriterTest().initProducts());

        assertEquals(JsonReader.getProductListFromJson(), productsExpected);
    }

    private List<Electronics> initProducts() {
        List<Electronics> products = new ArrayList<>();
        products.add(new TV4K(0, new BigDecimal(18000), "Samsung Ultra 4k", 115, 43.0, true, 3840, 9.8, 2160, 3840 * 2160, "16:10"));
        return products;
    }
}