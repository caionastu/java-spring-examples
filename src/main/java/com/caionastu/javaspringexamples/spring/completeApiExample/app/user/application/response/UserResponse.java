package com.caionastu.javaspringexamples.spring.completeApiExample.app.user.application.response;

import com.caionastu.javaspringexamples.spring.completeApiExample.app.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserResponse {

    private UUID id;
    private String name;
    private String email;

    public static UserResponse from(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.name = user.getName();
        userResponse.email = user.getEmail();

        return userResponse;
    }
}
