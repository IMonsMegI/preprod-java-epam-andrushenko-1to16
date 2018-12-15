package com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.TV4KConstructors;

import com.epam.AndriushchenkoMykhailo.Util.Util;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.TV4K;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.ElectronicsConstructor;

/**
 * Class for create TV4K object by user input
 */
public class ManualConstructorTV4K extends ElectronicsConstructor {

    /**
     * @return TV4K - object which construct by user input
     */
    @Override
    public Electronics makeProduct() {
        TV4K tv4K = new TV4K();
        tv4K.setId(0);
        System.out.println("Input cost:");
        tv4K.setCost(Util.getBigDecimalFromUser());
        System.out.println("Input model:");
        tv4K.setModel(Util.getStringFromUser());
        System.out.println("Input power:");
        tv4K.setPower(Util.getIntFromUser());
        System.out.println("Input diagonal:");
        tv4K.setDiagonal(Util.getDoubleFromUser());
        System.out.println("Is color? :");
        tv4K.setColor(Util.getBooleanFronUser());
        System.out.println("Input height:");
        tv4K.setHeight(Util.getDoubleFromUser());
        System.out.println("Input width:");
        tv4K.setWidth(Util.getDoubleFromUser());
        System.out.println("Input length:");
        tv4K.setLength(Util.getDoubleFromUser());
        System.out.println("Input count of pixels:");
        tv4K.setCountOfPixel(Util.getIntFromUser());
        System.out.println("Input aspect ratio:");
        tv4K.setAspectRatio(Util.getStringFromUser());
        return tv4K;
    }
}
