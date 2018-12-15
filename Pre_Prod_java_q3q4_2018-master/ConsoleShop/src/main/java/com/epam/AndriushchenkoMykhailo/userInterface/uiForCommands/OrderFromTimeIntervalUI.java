package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.Order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFromTimeIntervalUI {
    public Map<String, LocalDateTime> getDataFromUser() {
        Map<String, LocalDateTime> data = new HashMap<>();
        System.out.println("Input before date of order: ");
        LocalDateTime before = Util.getDateFromUser();
        System.out.println("Input after date of order: ");
        LocalDateTime after = Util.getDateFromUser();
        data.put("before", before);
        data.put("after", after);
        return data;
    }

    public void writeOrdersFromTimeInternal(List<Order> orders) {
        orders.forEach((order) -> System.out.println(order.getLocalDateTime() + " - " + order.getProducts().toString()));
        System.out.println();
        Util.writeUserMenu();
    }
}
