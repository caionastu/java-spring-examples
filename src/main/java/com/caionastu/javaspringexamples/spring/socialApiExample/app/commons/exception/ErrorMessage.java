package com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorMessage {

    private final String title;
    private final List<String> details = new ArrayList<>();

    public ErrorMessage(String title) {
        this.title = title;
    }

    public void addDetail(String detail) {
        details.add(detail);
    }
}
