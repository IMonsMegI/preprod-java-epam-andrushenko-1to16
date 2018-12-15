package com.epam.AndriushchenkoMykhailo.Task5.part2.searcher;

import java.io.File;

/**
 * Filter files by extension
 */
public class FileSearcherByExtension extends FileSearcher {
    private String fileExtension;

    /**
     * Constructor
     *
     * @param fileExtension - extension for searching files
     * @param fileSearcher  - next file searcher
     */
    public FileSearcherByExtension(String fileExtension, FileSearcher fileSearcher) {
        this.fileExtension = fileExtension;
        this.nextFilter = fileSearcher;
    }

    /**
     * Filter files by extension
     *
     * @param file - file for filer
     * @return true - if file pass filter
     */
    public boolean filter(File file) {
        return file.getName().endsWith("." + fileExtension);
    }
}
