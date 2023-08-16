package com.upesi.upesiauthserver.core.persistence.repository;

import com.upesi.upesiauthserver.core.persistence.entity.DeviceMetadata;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface DeviceMetadataRepository extends R2dbcRepository<DeviceMetadata, Long> {
    Flux<DeviceMetadata> findDeviceMetadataByUserId(long userId);
}
