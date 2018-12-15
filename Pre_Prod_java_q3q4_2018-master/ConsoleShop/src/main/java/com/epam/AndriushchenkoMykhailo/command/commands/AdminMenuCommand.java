package com.epam.AndriushchenkoMykhailo.command.commands;

import com.epam.AndriushchenkoMykhailo.application.Context;
import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.command.Command;
import com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands.AdminMenuUI;

import java.util.Map;

public class AdminMenuCommand implements Command {
    private static final String PASSWORD = "password";
    private AdminMenuUI adminMenuUI;

    public AdminMenuCommand(Context context) {
        adminMenuUI = context.getUiContainer().getAdminMenuUI();
    }

    @Override
    public void execute() {
        Map<String, String> data = adminMenuUI.getDataFromUser();
        String password = data.get(PASSWORD);
        if (Util.checkAdminPassword(password)) {
            adminMenuUI.writeAdminMenu();
        }
    }
}
