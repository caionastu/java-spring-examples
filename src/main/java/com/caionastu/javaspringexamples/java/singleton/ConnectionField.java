package com.caionastu.javaspringexamples.java.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ConnectionField {
    public static final ConnectionField INSTANCE = new ConnectionField();

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
