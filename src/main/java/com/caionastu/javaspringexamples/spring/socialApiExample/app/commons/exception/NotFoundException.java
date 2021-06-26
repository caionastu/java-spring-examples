package com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.exception;

public class NotFoundException extends BusinessException {

    public NotFoundException(String keyMessage) {
        super(keyMessage);
    }

    public NotFoundException(String keyMessage, Object... arguments) {
        super(keyMessage, arguments);
    }
}
