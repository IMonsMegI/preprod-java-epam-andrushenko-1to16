package com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.smartTVConstructors;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.SmartTV;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.ElectronicsConstructor;

/**
 * Class for create SmartTv object by user input
 */
public class ManualConstructorSmartTV extends ElectronicsConstructor {

    /**
     * @return smartTV - object which construct by user input
     */
    @Override
    public Electronics makeProduct() {
        SmartTV smartTV = new SmartTV();
        smartTV.setId(0);
        System.out.println("Input cost:");
        smartTV.setCost(Util.getBigDecimalFromUser());
        System.out.println("Input model:");
        smartTV.setModel(Util.getStringFromUser());
        System.out.println("Input power:");
        smartTV.setPower(Util.getIntFromUser());
        System.out.println("Input diagonal:");
        smartTV.setDiagonal(Util.getDoubleFromUser());
        System.out.println("Is color? :");
        smartTV.setColor(Util.getBooleanFronUser());
        System.out.println("Input height:");
        smartTV.setHeight(Util.getDoubleFromUser());
        System.out.println("Input width:");
        smartTV.setWidth(Util.getDoubleFromUser());
        System.out.println("Input length:");
        smartTV.setLength(Util.getDoubleFromUser());
        System.out.println("Is smart? :");
        smartTV.setSmartTV(Util.getBooleanFronUser());
        System.out.println("Input operating system:");
        smartTV.setOperatingSystem(Util.getStringFromUser());
        return smartTV;
    }
}
