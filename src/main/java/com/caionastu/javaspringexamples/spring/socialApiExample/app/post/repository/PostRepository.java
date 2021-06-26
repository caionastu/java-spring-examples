package com.caionastu.javaspringexamples.spring.socialApiExample.app.post.repository;

import com.caionastu.javaspringexamples.spring.socialApiExample.app.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    Page<Post> findByUserId(UUID id, Pageable pageable);
}
