package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.OrderService;
import com.epam.AndriushchenkoMykhailo.entities.Order;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.OrderFromTimeIntervalUI;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OrdersFromTimeIntervalCommand implements Command {
    private static final String BEFORE_DATE = "before";
    private static final String AFTER_DATE = "after";
    private OrderService orderService;
    private OrderFromTimeIntervalUI orderFromTimeIntervalUI;

    public OrdersFromTimeIntervalCommand(Context context) {
        this.orderService = context.getOrderService();
        this.orderFromTimeIntervalUI = context.getUiContainer().getOrderFromTimeIntervalUI();
    }

    @Override
    public void execute() {
        Map<String, LocalDateTime> data = orderFromTimeIntervalUI.getDataFromUser();
        List<Order> orders = orderService.getOrdersFromTimeInterval(data.get(BEFORE_DATE), data.get(AFTER_DATE));
        orderFromTimeIntervalUI.writeOrdersFromTimeInternal(orders);
    }
}
