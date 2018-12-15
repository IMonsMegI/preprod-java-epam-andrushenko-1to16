package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.Order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class NearestOrderByDateUI {
    public void writeNearestOrder(Order order) {
        System.out.println(order.getLocalDateTime() + "  -  " + order.getProducts());
    }

    public Map<String, LocalDateTime> getDataFromUser() {
        System.out.println("Input date of order: ");
        Map<String, LocalDateTime> data = new HashMap<>();
        LocalDateTime nearestDate = Util.getDateFromUser();
        data.put("nearestDate", nearestDate);
        return data;
    }
}
