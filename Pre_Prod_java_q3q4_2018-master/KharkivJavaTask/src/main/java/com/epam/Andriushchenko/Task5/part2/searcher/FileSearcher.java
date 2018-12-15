package com.epam.AndriushchenkoMykhailo.Task5.part2.searcher;

import java.io.File;

/**
 * Template for file filters
 */
public abstract class FileSearcher {
    FileSearcher nextFilter;

    /**
     * Filter method in all filters
     *
     * @param file - File object for filter
     */
    public abstract boolean filter(File file);

    /**
     * Check for the next filter is exist
     *
     * @param file - File object for filter
     * @return nextFilter
     */
    public boolean doFilter(File file) {
        boolean result = filter(file);
        if (nextFilter != null && result) {
            return nextFilter.doFilter(file);
        }
        return result;
    }
}
