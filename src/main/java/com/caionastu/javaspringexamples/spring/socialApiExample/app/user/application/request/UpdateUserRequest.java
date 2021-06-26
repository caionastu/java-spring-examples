package com.caionastu.javaspringexamples.spring.socialApiExample.app.user.application.request;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UpdateUserRequest {

    @NotBlank(message = "{name.notBlank}")
    @Size(max = 15, message = "{name.size}")
    @Pattern(regexp = "^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$", message = "{name.invalid}")
    private String name;
}
