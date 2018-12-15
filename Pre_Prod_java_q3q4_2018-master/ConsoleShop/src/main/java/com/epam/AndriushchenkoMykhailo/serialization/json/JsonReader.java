package com.epam.AndriushchenkoMykhailo.serialization.json;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for read products from json file
 */
public class JsonReader {
    private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * @return products - List<Electronics> which contains objects from json file
     */
    public static List<Electronics> getProductListFromJson() {
        List<Electronics> products = null;
        try {
            products = objectMapper.readValue(new File(/*"products.json"*/ "test.json"), new TypeReference<ArrayList<Electronics>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
