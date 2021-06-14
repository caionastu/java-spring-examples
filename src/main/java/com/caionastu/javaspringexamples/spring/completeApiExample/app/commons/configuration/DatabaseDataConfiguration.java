package com.caionastu.javaspringexamples.spring.completeApiExample.app.commons.configuration;

import com.caionastu.javaspringexamples.spring.completeApiExample.app.user.domain.User;
import com.caionastu.javaspringexamples.spring.completeApiExample.app.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Slf4j
@Configuration
public class DatabaseDataConfiguration {

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        return (String[] args) -> {
            log.info("=== Loading Database data ===");

            User user = new User(null, "John", "john@email.com");
            User user2 = new User(null, "Snow", "snow@email.com");

            userRepository.save(user);
            userRepository.save(user2);

            log.info("{}", user);

            log.info("=== Database loaded ===");
        };
    }
}
