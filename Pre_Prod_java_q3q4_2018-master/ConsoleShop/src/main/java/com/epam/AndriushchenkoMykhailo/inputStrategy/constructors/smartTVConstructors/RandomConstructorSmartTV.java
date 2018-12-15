package com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.smartTVConstructors;

import com.epam.AndriushchenkoMykhailo.Util.RandomValues;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.SmartTV;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.ElectronicsConstructor;

/**
 * Class for create SmartTv object by random values
 */
public class RandomConstructorSmartTV extends ElectronicsConstructor {

    /**
     * @return smartTV - object which construct by random values
     */
    @Override
    public Electronics makeProduct() {
        SmartTV product = new SmartTV();
        product.setId(0);
        product.setCost(RandomValues.getRandomBigDecimal());
        product.setModel(RandomValues.getRandomString("LG "));
        product.setPower(RandomValues.getRandomInt());
        product.setDiagonal(RandomValues.getRandomDouble());
        product.setColor(RandomValues.getRandomBoolean());
        product.setHeight(RandomValues.getRandomDouble());
        product.setWidth(RandomValues.getRandomDouble());
        product.setLength(RandomValues.getRandomDouble());
        product.setSmartTV(RandomValues.getRandomBoolean());
        product.setOperatingSystem(RandomValues.getRandomString("Android "));
        return product;
    }
}
