package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.UserMenuUI;

public class UserMenuCommand implements Command {
    private UserMenuUI userMenuUI;

    public UserMenuCommand(Context context) {
        userMenuUI = context.getUiContainer().getUserMenuUI();
    }

    @Override
    public void execute() {
        userMenuUI.writeUserMenu();
    }
}
