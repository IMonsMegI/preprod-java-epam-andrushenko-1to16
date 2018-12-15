package com.epam.AndriushchenkoMykhailo.Task5.part2.searcher;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Filter files by date
 */
public class FileSearcherByDate extends FileSearcher {
    private LocalDateTime beforeDate;
    private LocalDateTime afterDate;

    /**
     * Constructor
     *
     * @param beforeDate   - date of start checking duration
     * @param afterDate    - date of finish checking duration
     * @param fileSearcher - next file searcher
     */
    public FileSearcherByDate(LocalDateTime beforeDate, LocalDateTime afterDate, FileSearcher fileSearcher) {
        this.beforeDate = beforeDate;
        this.afterDate = afterDate;
        this.nextFilter = fileSearcher;
    }

    /**
     * Filter files by modified date
     *
     * @param file - file for filter
     * @return true - if file pass filter
     */
    public boolean filter(File file) {
        return (file.lastModified() > Instant.from(beforeDate).toEpochMilli()) &&
                (file.lastModified() < Instant.from(afterDate).toEpochMilli());
    }
}
