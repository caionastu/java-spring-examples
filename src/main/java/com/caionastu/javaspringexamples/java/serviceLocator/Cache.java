package com.caionastu.javaspringexamples.java.serviceLocator;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
class Cache {

    private final HashMap<String, IFileReader> readers = new HashMap<>();

    IFileReader getReader(ContentType contentType) {
        String readerName = contentType.getReaderName();
        if (readers.containsKey(readerName)) {
            log.info("Returning cached {}.", readerName);
            return readers.get(readerName);
        }

        return null;
    }

    void addReader(IFileReader reader) {
        String readerName = reader.getName();
        if (readers.containsKey(readerName)) {
            log.info("FileReader {} already cached.", readerName);
            return;
        }

        readers.put(readerName, reader);
    }

    // For Unit Test
    void clear() {
        readers.clear();
    }

    void logCached(){
        if (readers.size() == 0) {
            log.info("Cache empty. Nothing to log.");
            return;
        }

        log.info("Logging cached readers.");

        int count = 1;
        for (IFileReader value : readers.values()) {
            log.info("{} - {}", count, value.getName());
            count++;
        }

        log.info("Logging finished.");
    }
}
