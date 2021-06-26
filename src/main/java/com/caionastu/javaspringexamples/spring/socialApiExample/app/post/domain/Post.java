package com.caionastu.javaspringexamples.spring.socialApiExample.app.post.domain;

import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.domain.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Post {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String body;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}
