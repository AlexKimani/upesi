package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.User;
import com.upesi.upesiauthserver.core.persistence.entity.VerificationToken;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface VerificationTokenRepository extends R2dbcRepository<VerificationToken, Long> {
    Mono<VerificationToken> findByToken(String token);
    Mono<VerificationToken> findByUser(User user);
    Flux<VerificationToken> findAllByExpiryDateLessThan(Date now);
    Mono<Void> deleteByExpiryDateLessThan(Date now);
    @Modifying
    @Query("DELETE FROM tbl_verification_token t WHERE t.expiry_date")
    Mono<Void> deleteAllByExpiredSince(Date now);
}
