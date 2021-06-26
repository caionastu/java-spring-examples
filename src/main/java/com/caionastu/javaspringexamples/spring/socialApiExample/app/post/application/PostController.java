package com.caionastu.javaspringexamples.spring.socialApiExample.app.post.application;

import com.caionastu.javaspringexamples.spring.socialApiExample.app.commons.request.PageableRequest;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.application.request.CreatePostRequest;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.application.response.PostResponse;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.domain.Post;
import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostRepository repository;

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Page<PostResponse>> findAllByUser(PageableRequest request, @PathVariable UUID id) {
        Page<Post> posts = repository.findByUserId(id, request.toPageable());
        Page<PostResponse> response = posts.map(PostResponse::from);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody CreatePostRequest request) {
        return ResponseEntity.ok().build();
    }

}
