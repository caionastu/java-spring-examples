package com.caionastu.javaspringexamples.spring.completeApiExample.app.user.domain;

import com.caionastu.javaspringexamples.spring.completeApiExample.app.user.application.request.CreateUserRequest;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;


    public static User from(CreateUserRequest request) {
        User user = new User();
        user.name = request.getName();
        user.email = request.getEmail();

        return user;
    }
}
