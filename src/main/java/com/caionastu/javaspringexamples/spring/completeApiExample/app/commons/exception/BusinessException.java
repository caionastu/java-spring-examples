package com.caionastu.javaspringexamples.spring.completeApiExample.app.commons.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessException extends RuntimeException {

    @Getter
    private final String keyMessage;

    private List<Object> arguments = new ArrayList<>();

    public BusinessException(String keyMessage) {
        this.keyMessage = keyMessage;
    }

    public BusinessException(String keyMessage, Object... arguments) {
        this.keyMessage = keyMessage;
        this.arguments = Arrays.asList(arguments.clone());
    }

    public Object[] getArguments() {
        return arguments.toArray();
    }
}
