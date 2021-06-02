package com.caionastu.javaspringexamples.java.serviceLocator;

import lombok.Getter;

enum ContentType {
    CSV(ReaderConstants.CSV),
    JSON(ReaderConstants.JSON),
    TEXT(ReaderConstants.TEXT);

    @Getter
    private final String readerName;

    ContentType(String readerName) {
        this.readerName = readerName;
    }
}
