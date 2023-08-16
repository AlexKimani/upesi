package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.NewLocationToken;
import com.upesi.upesiauthserver.core.persistence.entity.UserLocation;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface NewLocationTokenRepository extends R2dbcRepository<NewLocationToken, Long> {
    Mono<NewLocationToken> findByToken(String token);
    Mono<NewLocationToken> findByUserLocation(UserLocation userLocation);
}
