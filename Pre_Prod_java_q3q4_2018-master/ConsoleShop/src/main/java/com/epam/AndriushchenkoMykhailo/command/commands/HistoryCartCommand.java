package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.CartHistoryService;
import com.epam.AndriushchenkoMykhailo.entities.CartHistoryProduct;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.HistoryCartUI;

import java.util.List;

public class HistoryCartCommand implements Command {
    private HistoryCartUI historyCartUI;
    private CartHistoryService cartHistoryService;

    public HistoryCartCommand(Context context) {
        this.historyCartUI = context.getUiContainer().getHistoryCartUI();
        this.cartHistoryService = context.getCartHistoryService();
    }

    @Override
    public void execute() {
        List<CartHistoryProduct> cartHistoryProducts = cartHistoryService.getCartHistory();
        historyCartUI.writeCartHistory(cartHistoryProducts);
    }
}
