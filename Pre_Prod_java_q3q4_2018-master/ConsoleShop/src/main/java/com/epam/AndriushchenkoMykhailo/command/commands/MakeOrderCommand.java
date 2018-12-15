package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.CartService;
import com.epam.AndriushchenkoMykhailo.dao.services.OrderService;
import com.epam.AndriushchenkoMykhailo.dao.services.ProductsService;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.MakeOrderUI;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MakeOrderCommand implements Command {
    private static final String DATE = "date";
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String SUM_COST_OF_PRODUCTS = "sumCostOfProducts";
    private CartService cartService;
    private OrderService orderService;
    private MakeOrderUI makeOrderUI;
    private ProductsService productsService;

    public MakeOrderCommand(Context context) {
        this.cartService = context.getCartService();
        this.orderService = context.getOrderService();
        this.makeOrderUI = context.getUiContainer().getMakeOrderUI();
        this.productsService = context.getProductsService();
    }

    @Override
    public void execute() {
        Map<String, LocalDateTime> data = makeOrderUI.getDataFromUser();
        Map<String, Object> processedData = orderService.addOrder(data.get(DATE), cartService, productsService);
        cartService.clearCart();
        makeOrderUI.writeProductsInfo((List<Electronics>) processedData.get(ORDER_PRODUCTS));
        makeOrderUI.writeMakeOrderResult((BigDecimal) processedData.get(SUM_COST_OF_PRODUCTS), data.get(DATE));
    }
}
