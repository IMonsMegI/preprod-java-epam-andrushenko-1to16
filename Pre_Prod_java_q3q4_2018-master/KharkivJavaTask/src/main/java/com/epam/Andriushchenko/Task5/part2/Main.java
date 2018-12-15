package com.epam.AndriushchenkoMykhailo.Task5.part2;

import com.epam.AndriushchenkoMykhailo.Task5.part2.searcher.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private List<File> files = new ArrayList<>();
    private FileSearcher currentFilter;

    public static void main(String[] args) {
        Main main = new Main();
        main.initDirectory();
        main.initChain();
        main.files.removeIf(file -> !main.currentFilter.doFilter(file));
        main.writeFileList();
    }

    private void initDirectory() {
        System.out.println("Input directory: ");
        String inputDirectory = scanner.nextLine();
        try {
            File foled = new File(inputDirectory);
            findFiles(foled);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void findFiles(File folder) {
        File[] filesInFolder = folder.listFiles();
        for (File entry : filesInFolder) {
            if (entry.isDirectory()) {
                findFiles(entry);
                continue;
            }
            files.add(entry);
        }
    }

    private void initChain() {
        System.out.println("Search by file name? (1/0)");
        if (Util.getAnswerFromUser()) {
            System.out.println("Input file name: ");
            String fileName = Util.getStringFromUser();
            currentFilter = new FileSearcherByName(fileName, currentFilter);
        }
        System.out.println("Search by file extension? (1/0)");
        if (Util.getAnswerFromUser()) {
            System.out.println("Input file extension: ");
            String fileExtension = Util.getStringFromUser();
            currentFilter = new FileSearcherByExtension(fileExtension, currentFilter);
        }
        System.out.println("Search by file size? (1/0)");
        if (Util.getAnswerFromUser()) {
            System.out.println("Input file minimum size (kb): ");
            long minFileSize = Util.getLongFromUser();
            System.out.println("Input file maximum size (kb): ");
            long maxFileSize = Util.getLongFromUser();
            currentFilter = new FileSearcherBySize(minFileSize, maxFileSize, currentFilter);
        }
        System.out.println("Search by file date? (1/0)");
        if (Util.getAnswerFromUser()) {
            System.out.println("Input file date of change(before): ");
            LocalDateTime beforeDate = Util.getDateFromUser();
            System.out.println("Input file date of change(after): ");
            LocalDateTime afterDate = Util.getDateFromUser();
            currentFilter = new FileSearcherByDate(beforeDate, afterDate, currentFilter);
        }
    }

    private void writeFileList() {
        for (File file : files) {
            System.out.println(file.getPath() + "  |  " + file.getName() + "  |  " + file.length());
        }
    }
}