package com.caionastu.javaspringexamples.java.serviceLocator;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
class FileReaderContext {

    private static FileReaderContext instance;
    private static final HashMap<String, IFileReader> readers = new HashMap<>();

    private FileReaderContext() {
        loadInitialContext();
    }

    static FileReaderContext getInstance() {
        if (instance == null) {
            instance = new FileReaderContext();
        }

        return instance;
    }

    private void loadInitialContext() {
        readers.put(ReaderConstants.JSON, new JsonReader());
        readers.put(ReaderConstants.CSV, new CsvReader());
    }

    void register(IFileReader reader) {
        String readerName = reader.getName();
        if (readers.containsKey(readerName)) {
            log.error("FileReader with name {} already registered.", readerName);
            throw new FileReaderAlreadyExistInContextException();
        }

        readers.put(readerName, reader);
        log.info("Reader {} registered.", readerName);
    }

    IFileReader getReader(ContentType contentType) {
        String readerName = contentType.getReaderName();
        if (!readers.containsKey(readerName)) {
            log.error("FileReader with name {} not found.", readerName);
            throw new FileReaderNotFoundException();
        }

        return readers.get(readerName);
    }

    // For Unit Test
    void resetContext() {
        readers.clear();
        loadInitialContext();
    }

}
