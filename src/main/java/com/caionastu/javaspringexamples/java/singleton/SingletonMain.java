package com.caionastu.javaspringexamples.java.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SingletonMain {

    public static void main(String[] args) {
        connectionEnum();
        connectionField();
        connectionStaticFactory();
    }

    private static void connectionEnum() {
        ConnectionEnum connectionEnum = ConnectionEnum.INSTANCE;
        log.info("ConnectionEnum is connected: {}", connectionEnum.isConnected());

        log.info("ConnectionEnum connecting...");
        connectionEnum.connectTo("path");
        log.info("ConnectionEnum is connected: {}", connectionEnum.isConnected());

        log.info("ConnectionEnum disconnecting...");
        connectionEnum.disconnect();
        log.info("ConnectionEnum is connected: {}", connectionEnum.isConnected());
    }

    private static void connectionField() {
        ConnectionField connectionField = ConnectionField.INSTANCE;
        log.info("ConnectionField is connected: {}", connectionField.isConnected());

        log.info("ConnectionField connecting...");
        connectionField.connectTo("path");
        log.info("ConnectionField is connected: {}", connectionField.isConnected());

        log.info("ConnectionField disconnecting...");
        connectionField.disconnect();
        log.info("ConnectionField is connected: {}", connectionField.isConnected());
    }

    private static void connectionStaticFactory() {
        ConnectionStaticFactory connectionStaticFactory = ConnectionStaticFactory.getInstance();
        log.info("ConnectionStaticFactory is connected: {}", connectionStaticFactory.isConnected());

        log.info("ConnectionStaticFactory connecting...");
        connectionStaticFactory.connectTo("path");
        log.info("ConnectionStaticFactory is connected: {}", connectionStaticFactory.isConnected());

        log.info("ConnectionStaticFactory disconnecting...");
        connectionStaticFactory.disconnect();
        log.info("ConnectionStaticFactory is connected: {}", connectionStaticFactory.isConnected());
    }
}
