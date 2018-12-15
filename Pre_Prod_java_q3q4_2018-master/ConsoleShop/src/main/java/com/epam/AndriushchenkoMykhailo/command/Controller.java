package com.epam.AndriushchenkoMykhailo.command;

import com.epam.AndriushchenkoMykhailo.application.Context;

public class Controller {
    private CommandContainer commandContainer;

    public Controller(Context context){
        commandContainer = new CommandContainer(context);
    }

    public void processCommand(String command) {
        try {
            commandContainer.commands.get(command).execute();
        } catch (Exception ex) {
            System.out.println("No command");
        }
    }
}
