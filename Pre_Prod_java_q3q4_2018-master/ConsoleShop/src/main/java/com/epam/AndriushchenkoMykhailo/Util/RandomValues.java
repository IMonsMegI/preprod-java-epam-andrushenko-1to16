package com.epam.AndriushchenkoMykhailo.Util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Class for generation random values
 */
public class RandomValues {
    private static Random random = new Random();

    /**
     * Generate random int from bound
     *
     * @return int - ramdom int value from 10000 to 50000
     */
    public static int getRandomInt() {
        return 10000 + random.nextInt(50000);
    }

    /**
     * Generate random BigDecimal from bound
     *
     * @return BigDecimal - ramdom BigDecimal value from 10000 to 50000
     */
    public static BigDecimal getRandomBigDecimal() {
        return new BigDecimal(10000 + random.nextInt(50000));
    }

    /**
     * Generate random string
     *
     * @param name - part of return string pattern
     * @return string - string in pattern name + int in bound from 100000 to 999999
     */
    public static String getRandomString(String name) {
        return name + (100000 + random.nextInt(999999));
    }

    /**
     * Generate random double from bound
     *
     * @return double - ramdom double value from 10
     */
    public static double getRandomDouble() {
        return 10.0 + random.nextDouble();
    }

    /**
     * Generate random boolean from bound
     *
     * @return boolean - ramdom boolean value
     */
    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
