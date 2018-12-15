package com.epam.AndriushchenkoMykhailo.application;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.command.Controller;

public class ApplicationController {
    private Context context = new Context();
    private Controller controller = new Controller(context);

    public void appDriver() {
        String inputCommand;

        Util.writeStartMenu();
        while (true) {
            if ("exit".equals(inputCommand = Util.getStringFromUser())) {
                context.getProductsService().saveProductsToJson();
                break;
            }
            controller.processCommand(inputCommand);
        }
    }
}
