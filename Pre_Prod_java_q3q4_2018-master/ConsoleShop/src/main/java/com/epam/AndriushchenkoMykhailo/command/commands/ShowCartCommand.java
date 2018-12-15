package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.dao.services.CartService;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.ShowCartUI;

public class ShowCartCommand implements Command {
    private ShowCartUI showCartUI;
    private CartService cartService;

    public ShowCartCommand(Context context) {
        this.showCartUI = context.getUiContainer().getShowCartUI();
        this.cartService = context.getCartService();
    }

    @Override
    public void execute() {
        showCartUI.writeCart(cartService.getCart());
    }
}
