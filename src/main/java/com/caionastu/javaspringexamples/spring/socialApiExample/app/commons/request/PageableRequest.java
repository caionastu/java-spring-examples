package com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@AllArgsConstructor
public class PageableRequest {

    private final int pageSize;
    private final int pageNumber;

    public PageableRequest() {
        pageNumber = 0;
        pageSize = 20;
    }

    public Pageable toPageable() {
        return PageRequest.of(pageNumber, pageSize);
    }
}
