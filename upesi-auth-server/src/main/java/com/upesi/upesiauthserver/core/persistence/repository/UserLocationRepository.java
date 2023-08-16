package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.User;
import com.upesi.upesiauthserver.core.persistence.entity.UserLocation;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserLocationRepository extends R2dbcRepository<UserLocation, Long> {
    Mono<UserLocation> findByCountryAndUser(String country, User user);
}
