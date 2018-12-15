package com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.TV4KConstructors;

import com.epam.AndriushchenkoMykhailo.Util.RandomValues;
import com.epam.AndriushchenkoMykhailo.entities.products.Electronics;
import com.epam.AndriushchenkoMykhailo.entities.products.TV4K;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.ElectronicsConstructor;

/**
 * Class for create TV4K object by random values
 */
public class RandomConstructorTV4K extends ElectronicsConstructor {

    /**
     * @return TV4K - object which construct by random values
     */
    @Override
    public Electronics makeProduct() {
        TV4K product = new TV4K();
        product.setId(0);
        product.setCost(RandomValues.getRandomBigDecimal());
        product.setModel(RandomValues.getRandomString("LG "));
        product.setPower(RandomValues.getRandomInt());
        product.setDiagonal(RandomValues.getRandomDouble());
        product.setColor(RandomValues.getRandomBoolean());
        product.setHeight(RandomValues.getRandomDouble());
        product.setWidth(RandomValues.getRandomDouble());
        product.setLength(RandomValues.getRandomDouble());
        product.setCountOfPixel(RandomValues.getRandomInt());
        product.setAspectRatio(RandomValues.getRandomString(RandomValues.getRandomInt() + " : " + RandomValues.getRandomInt()));
        return product;
    }
}
