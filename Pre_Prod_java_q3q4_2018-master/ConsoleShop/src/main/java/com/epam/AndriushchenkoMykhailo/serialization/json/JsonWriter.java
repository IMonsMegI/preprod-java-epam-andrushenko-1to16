package com.epam.AndriushchenkoMykhailo.serialization.json;

import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Class for write product list to json file after application ending
 */
public class JsonWriter {
    private static ObjectMapper objectMapper = new ObjectMapper().configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

    /**
     * @param products - List<Electronics> for write to json file
     */
    public static void writeProductListToJson(List<Electronics> products) {
        try {
            objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.WRAPPER_ARRAY);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(/*"products.json"*/"test.json"), products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
