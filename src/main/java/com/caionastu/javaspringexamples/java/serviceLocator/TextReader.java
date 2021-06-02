package com.caionastu.javaspringexamples.java.serviceLocator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TextReader implements IFileReader {

    @Override
    public void read(String file) {
        log.info("TEXT Reader reading a file. File content: {}", file);
    }

    @Override
    public String getName() {
        return ReaderConstants.TEXT;
    }
}
