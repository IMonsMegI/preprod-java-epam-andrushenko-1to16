package com.epam.andriushchenko.cache;

public enum HttpCacheHeader {
    CACHE_CONTROL("Cache-Control"),
    EXPIRES("Expires"),
    PRAGMA("Pragma"),
    ETAG("ETag"),
    VARY("Vary");

    private final String name;

    private HttpCacheHeader(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
