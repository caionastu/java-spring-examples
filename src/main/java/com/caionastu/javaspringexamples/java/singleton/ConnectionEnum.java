package com.caionastu.javaspringexamples.java.singleton;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

enum ConnectionEnum {
    INSTANCE;

    @Getter
    private boolean connected = false;

    @Getter
    private String path = Strings.EMPTY;

    public boolean connectTo(String path) {
        this.path = path;
        connected = true;
        return true;
    }

    public void disconnect() {
        path = Strings.EMPTY;
        connected = false;
    }

}
