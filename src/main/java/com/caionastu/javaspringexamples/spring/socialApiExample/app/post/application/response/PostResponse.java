package com.caionastu.javaspringexamples.spring.socialApiExample.app.post.application.response;

import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.domain.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponse {

    private UUID id;
    private String title;
    private String body;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime date;

    public static PostResponse from(Post post) {
        PostResponse response = new PostResponse();
        response.id = post.getId();
        response.title = post.getTitle();
        response.body = post.getBody();
        response.date = post.getDate();

        return response;
    }
}
