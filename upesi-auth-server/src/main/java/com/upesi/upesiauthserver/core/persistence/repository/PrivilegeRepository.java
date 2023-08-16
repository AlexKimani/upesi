package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.Privilege;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface PrivilegeRepository extends R2dbcRepository<Privilege, Long> {
    Mono<Privilege> findByName(String name);
    Mono<Void> deletePrivilegeBy(Privilege privilege);
}
