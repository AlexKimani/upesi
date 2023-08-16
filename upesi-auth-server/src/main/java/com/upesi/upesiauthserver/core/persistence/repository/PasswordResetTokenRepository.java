package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.PasswordResetToken;
import com.upesi.upesiauthserver.core.persistence.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface PasswordResetTokenRepository extends R2dbcRepository<PasswordResetToken, Long> {
    Mono<PasswordResetToken> findByToken(String token);
    Mono<PasswordResetToken> findByUser(User user);
    Flux<PasswordResetToken> findAllByExpiryDateLessThan(Date now);
    Mono<Void> deleteByExpiryDateLessThan(Date now);
    @Modifying
    @Query("DELETE FROM tbl_password_reset_token t WHERE t.expiry_date <= ?1")
    Mono<Void> deleteAllExpiredSince(Date now);
}
