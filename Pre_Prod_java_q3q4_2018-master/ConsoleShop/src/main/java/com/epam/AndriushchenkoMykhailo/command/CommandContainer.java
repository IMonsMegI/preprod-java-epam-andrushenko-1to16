package com.epam.AndriushchenkoMykhailo.command;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    Map<String, Command> commands = new HashMap<>();

    public CommandContainer(Context context) {
        commands.put("user", new UserMenuCommand(context));
        commands.put("admin", new AdminMenuCommand(context));
        commands.put("products", new ProductsCommand(context));
        commands.put("cart", new ShowCartCommand(context));
        commands.put("add to cart", new AddToCartCommand(context));
        commands.put("add product", new AddProductCommand(context));
        commands.put("make order", new MakeOrderCommand(context));
        commands.put("history cart", new HistoryCartCommand(context));
        commands.put("orders from time interval", new OrdersFromTimeIntervalCommand(context));
        commands.put("get nearest order", new NearestOrderByDateCommand(context));
    }
}
