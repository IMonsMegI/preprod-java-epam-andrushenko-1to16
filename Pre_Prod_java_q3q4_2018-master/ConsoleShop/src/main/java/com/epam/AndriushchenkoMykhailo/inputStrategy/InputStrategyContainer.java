package com.epam.AndriushchenkoMykhailo.inputStrategy;

import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.ElectronicsConstructor;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.TV4KConstructors.ManualConstructorTV4K;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.TV4KConstructors.RandomConstructorTV4K;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.smartTVConstructors.ManualConstructorSmartTV;
import com.epam.AndriushchenkoMykhailo.inputStrategy.constructors.smartTVConstructors.RandomConstructorSmartTV;

import java.util.HashMap;
import java.util.Map;

/**
 * Container of input variants
 */
public class InputStrategyContainer {
    private Map<Enum, Map<Enum, ElectronicsConstructor>> strategy = new HashMap<>();
    private Map<Enum, ElectronicsConstructor> randomInput = new HashMap<>();
    private Map<Enum, ElectronicsConstructor> manualInput = new HashMap<>();

    {
        manualInput.put(ProductType.SMARTTV, new ManualConstructorSmartTV());
        manualInput.put(ProductType.TV4K, new ManualConstructorTV4K());
        randomInput.put(ProductType.SMARTTV, new RandomConstructorSmartTV());
        randomInput.put(ProductType.TV4K, new RandomConstructorTV4K());

        strategy.put(InputType.MANUAL, manualInput);
        strategy.put(InputType.RANDOM, randomInput);
    }

    /**
     * @return strategy of input and type of product for create
     */
    public ElectronicsConstructor getElectronicConstructor(InputType inputType, ProductType productType) {
        if (!strategy.containsKey(inputType)) {
            throw new IllegalArgumentException();
        }
        return strategy.get(inputType).get(productType);
    }
}
