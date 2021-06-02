package com.caionastu.javaspringexamples.java.serviceLocator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class FileReaderLocator {

    private static FileReaderLocator instance;
    private static final Cache cache = new Cache();

    static FileReaderLocator getInstance() {
        if (instance == null) {
            instance = new FileReaderLocator();
        }

        return instance;
    }

    IFileReader getReader(ContentType contentType) {
        IFileReader reader = cache.getReader(contentType);

        if (reader != null) {
            return reader;
        }

        reader = FileReaderContext.getInstance()
                .getReader(contentType);

        cache.addReader(reader);
        return reader;
    }

    void clearCache() {
        cache.clear();
    }

    void logCachedReaders() {
        cache.logCached();
    }
}
