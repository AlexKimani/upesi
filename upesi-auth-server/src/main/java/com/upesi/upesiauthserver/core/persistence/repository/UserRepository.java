package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {
    Mono<User> findByEmail(String email);
    Mono<User> findByPhoneNumber(long phoneNumber);
    Mono<Void> deleteBy(User user);
}
