package com.epam.AndriushchenkoMykhailo.Task5.part2.searcher;

import java.io.File;

/**
 * Filter files by size
 */
public class FileSearcherBySize extends FileSearcher {
    private static final int KILOBYTE = 1024;
    private long minFileSize;
    private long maxFileSize;

    /**
     * Constructor
     *
     * @param minFileSize  - minimum file size for searching
     * @param maxFileSize  - maximum file size for searching
     * @param fileSearcher - next file searcher
     */
    public FileSearcherBySize(long minFileSize, long maxFileSize, FileSearcher fileSearcher) {
        this.minFileSize = minFileSize;
        this.maxFileSize = maxFileSize;
        this.nextFilter = fileSearcher;
    }

    /**
     * Filter files by size
     *
     * @param file - file for filer
     * @return true - if file pass filter
     */
    public boolean filter(File file) {
        return (file.length() >= minFileSize * KILOBYTE && file.length() <= maxFileSize * KILOBYTE);
    }
}
