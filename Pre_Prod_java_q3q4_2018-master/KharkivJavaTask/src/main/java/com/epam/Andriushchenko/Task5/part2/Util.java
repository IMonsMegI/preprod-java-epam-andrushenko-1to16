package com.epam.AndriushchenkoMykhailo.Task5.part2;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean getAnswerFromUser() {
        int input = scanner.nextInt();
        if (input == 1) {
            return true;
        }
        return false;
    }

    public static String getStringFromUser() {
        String input = scanner.next();
        return input;
    }

    public static void printListOfFiles(List<File> files) {
        files.forEach(file -> System.out.println(file.getPath() + "  |  " + file.getName() + "  |  b: " + file.length()));
    }

    public static long getLongFromUser() {
        long input = scanner.nextLong();
        return input;
    }

    public static LocalDateTime getDateFromUser() {
        Scanner scan = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.now();
        try {
            date = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        } catch (Exception ex) {
            System.out.println("Wrong format of date!");
        }
        return date;
    }
}
