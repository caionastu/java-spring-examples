package com.caionastu.javaspringexamples.spring.completeApiExample.app.post.domain;

import com.caionastu.javaspringexamples.spring.completeApiExample.app.user.domain.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

//@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String body;
    private LocalDateTime date;

    // TODO: 10-Jun-21 Relationship ManyToOne
    private User user;
}
