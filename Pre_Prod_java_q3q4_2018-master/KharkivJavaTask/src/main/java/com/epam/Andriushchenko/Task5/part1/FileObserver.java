package com.epam.AndriushchenkoMykhailo.Task5.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Passes a file and returns separate rows
 */
public class FileObserver {
    private BufferedReader reader;

    /**
     * Constructor
     *
     * @param fileName - name of file
     * @throws FileNotFoundException - if file not found
     */
    public FileObserver(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    /**
     * Return new Iterator()
     *
     * @return FileIterator
     */
    public Iterator iterator() {
        return new FileIterator();
    }

    private class FileIterator implements Iterator {
        /**
         * Check for the next line in file
         *
         * @return true - if next line exist
         */
        public boolean hasNext() {
            try {
                return reader.ready();
            } catch (IOException e) {
                System.out.println("File not ready to read");
            }
            return false;
        }

        /**
         * Return line from file
         *
         * @return The next line in file
         * @throws NoSuchElementException - if next line not exist
         */
        public Object next() {
            if (hasNext()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    System.out.println("No more lines for read");
                }
            }
            throw new NoSuchElementException();
        }

        /**
         * @throws UnsupportedOperationException
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        FileObserver fileObserver;
        FileIterator fileIterator;
        try {
            fileObserver = new FileObserver("fileForPart1.txt");
            fileIterator = (FileIterator) fileObserver.iterator();
            for (int i = 0; i < 7; i++) {
                System.out.println(fileIterator.next());
            }
            System.out.println(fileIterator.hasNext());
            while (fileIterator.hasNext()) {
                System.out.println(fileIterator.next());
            }
            fileIterator.next();
        } catch (FileNotFoundException e) {
            System.out.println("Cant find file");
        }
    }
}
