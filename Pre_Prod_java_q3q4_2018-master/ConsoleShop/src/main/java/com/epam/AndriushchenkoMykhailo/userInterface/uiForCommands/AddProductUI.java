package com.epam.AndriushchenkoMykhailo.userInterface.uiForCommands;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.inputStrategy.InputType;

public class AddProductUI {
    private InputType inputType;

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public InputType getInputType() {
        return inputType;
    }

    public String getInputTypeFromUser() {
        System.out.println("Choose type of input:   (random / manual)");
        return Util.getStringFromUser();
    }

    public String getProductTypeFromUser() {
        System.out.println("Which product do you need to add?   (smarttv / tv4k)");
        return Util.getStringFromUser();
    }

    public void infoNewProductAdded() {
        System.out.println("New product added.");
    }
}
