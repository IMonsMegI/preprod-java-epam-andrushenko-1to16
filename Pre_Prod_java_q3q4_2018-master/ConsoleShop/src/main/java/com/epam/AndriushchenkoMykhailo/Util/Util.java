package com.epam.AndriushchenkoMykhailo.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Util {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String adminPassword = "admin";

    public static void writeUserMenu() {
        System.out.println("0. Menu.   (menu)");
        System.out.println("1. Product list.   (products)");
        System.out.println("2. Add product to basket(№ / count).  (add to cart)");
        System.out.println("3. Show cart.   (cart)");
        System.out.println("4. Make order.   (make order)");
        System.out.println("5. Show cart history.   (history cart)");
        System.out.println("6. Show orders from time interval.   (orders from time interval)");
        System.out.println("7. Show nearest order to date.   (get nearest order)");
    }

    public static void writeStartMenu() {
        System.out.println("1. Admin   (admin)");
        System.out.println("2. User   (user)");
        System.out.println("Exit   (exit)");
    }

    public static boolean checkAdminPassword(String password) {
        if (!password.equals(adminPassword)) {
            Util.writeStartMenu();
            return false;
        }
        return true;
    }

    public static LocalDateTime getDateFromUser() {
        try {
            return LocalDateTime.parse(getStringFromUser(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        } catch (Exception ex) {
            System.out.println("Wrong format of date!");
        }
        throw new InputMismatchException("Wrong format of date!");
    }

    public static int getIntFromUser() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (Exception ex) {
            System.out.println("Wrong format of data!");
        }
        return 0;
    }

    public static String getStringFromUser() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static BigDecimal getBigDecimalFromUser() {
        try {
            return BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine()));
        } catch (IOException e) {
            System.out.println("Wrong format of data!");
        }
        return BigDecimal.ZERO;
    }

    public static double getDoubleFromUser() {
        try {
            return Double.parseDouble(bufferedReader.readLine());
        } catch (IOException e) {
            System.out.println("Wrong format of data!");
        }
        return 0;
    }

    public static boolean getBooleanFronUser() {
        try {
            return Integer.parseInt(bufferedReader.readLine()) > 0;
        } catch (IOException e) {
            System.out.println("Wrong format of data!");
        }
        return false;
    }
}
