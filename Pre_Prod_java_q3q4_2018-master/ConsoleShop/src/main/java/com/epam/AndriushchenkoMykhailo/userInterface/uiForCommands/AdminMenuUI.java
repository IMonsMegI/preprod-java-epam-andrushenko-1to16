package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;

import java.util.HashMap;
import java.util.Map;

public class AdminMenuUI {

    public Map<String, String> getDataFromUser() {
        Map<String, String> data = new HashMap<>();
        System.out.println("Input password: ");
        String password = Util.getStringFromUser();
        data.put("password", password);
        return data;
    }

    public void writeAdminMenu() {
        System.out.println("1. Add new product   (add product)");
    }
}
