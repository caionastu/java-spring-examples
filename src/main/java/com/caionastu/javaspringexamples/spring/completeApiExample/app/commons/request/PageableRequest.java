package com.caionastu.javaspringexamples.spring.completeApiExample.app.commons.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PageableRequest {

    private int pageSize;
    private int pageNumber;

    public Pageable toPageable() {
        return PageRequest.of(pageNumber, pageSize);
    }
}
