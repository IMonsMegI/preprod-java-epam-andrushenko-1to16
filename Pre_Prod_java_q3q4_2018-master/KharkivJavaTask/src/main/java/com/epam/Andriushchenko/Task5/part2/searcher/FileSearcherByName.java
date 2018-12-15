package com.epam.AndriushchenkoMykhailo.Task5.part2.searcher;

import java.io.File;

/**
 * Filter files by name
 */
public class FileSearcherByName extends FileSearcher {
    private String fileName;

    /**
     * Constructor
     *
     * @param fileName     - name of file, which is in filter
     * @param fileSearcher - next file searcher
     */
    public FileSearcherByName(String fileName, FileSearcher fileSearcher) {
        this.fileName = fileName;
        this.nextFilter = fileSearcher;
    }

    /**
     * Filter files by name
     *
     * @param file - file object for filter
     * @return true - if file pass filter
     */
    public boolean filter(File file) {
        return file.getName().startsWith(fileName + ".");
    }
}
