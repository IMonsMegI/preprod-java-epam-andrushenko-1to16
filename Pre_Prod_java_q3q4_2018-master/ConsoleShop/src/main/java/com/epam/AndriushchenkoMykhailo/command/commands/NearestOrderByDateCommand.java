package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.OrderService;
import com.epam.AndriushchenkoMykhailo.entities.Order;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.NearestOrderByDateUI;

import java.time.LocalDateTime;
import java.util.Map;

public class NearestOrderByDateCommand implements Command {
    private static final String NEAREST_DATE = "nearestDate";
    private NearestOrderByDateUI nearestOrderByDateUI;
    private OrderService orderService;

    public NearestOrderByDateCommand(Context context) {
        this.nearestOrderByDateUI = context.getUiContainer().getNearestOrderByDateUI();
        this.orderService = context.getOrderService();
    }

    @Override
    public void execute() {
        Map<String, LocalDateTime> data = nearestOrderByDateUI.getDataFromUser();
        Order order = orderService.getNearestOrderToDate(data.get(NEAREST_DATE));
        nearestOrderByDateUI.writeNearestOrder(order);
    }
}
