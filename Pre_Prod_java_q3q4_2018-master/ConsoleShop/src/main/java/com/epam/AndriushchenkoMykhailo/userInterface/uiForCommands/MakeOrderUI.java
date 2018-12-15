package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeOrderUI {
    public void writeMakeOrderResult(BigDecimal sumCostOfProducts, LocalDateTime date) {
        System.out.println("Sum of order: " + sumCostOfProducts);
        System.out.println("Date of order: " + date.toString());
        System.out.println();
        Util.writeUserMenu();
    }

    public Map<String, LocalDateTime> getDataFromUser() {
        System.out.println("Input date of order: ");
        Map<String, LocalDateTime> data = new HashMap<>();
        LocalDateTime date = Util.getDateFromUser();
        data.put("date", date);
        return data;
    }

    public void writeProductsInfo(List<Electronics> products) {
        products.forEach((product) -> System.out.println("Number of product: " + product.getId() +
                "|   Model: " + product.getModel() +
                "|   Cost: " + product.getCost()));
    }
}
