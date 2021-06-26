package com.caionastu.javaspringexamples.spring.socialApiExample.app.user.application;

import com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.request.PageableRequest;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.application.request.CreateUserRequest;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.application.request.UpdateUserRequest;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.application.response.UserResponse;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.domain.User;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.exception.UserEmailAlreadyExistException;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.exception.UserNotFoundException;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> findAll(PageableRequest request) {
        Page<UserResponse> users = repository.findAll(request.toPageable())
                .map(UserResponse::from);

        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        UserResponse response = UserResponse.from(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUserRequest userRequest) {
        repository.findByEmail(userRequest.getEmail())
                .ifPresent(user -> {
                    throw new UserEmailAlreadyExistException(userRequest.getEmail());
                });

        User newUser = User.from(userRequest);
        repository.save(newUser);

        UserResponse response = UserResponse.from(newUser);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateName(@PathVariable UUID id, @RequestBody @Valid UpdateUserRequest userRequest) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        User updateUser = new User(user.getId(), userRequest.getName(), user.getEmail());
        repository.save(updateUser);

        UserResponse response = UserResponse.from(updateUser);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
