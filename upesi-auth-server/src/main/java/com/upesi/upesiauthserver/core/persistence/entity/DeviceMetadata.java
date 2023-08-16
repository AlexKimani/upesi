package com.upesi.upesiauthserver.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tbl_device_metadata")
public class DeviceMetadata extends AbstractValues {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String deviceDetails;
    private String location;
    private Date lastLoggedIn;

    public DeviceMetadata() {
        super();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeviceMetadata{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", deviceDetails='").append(deviceDetails).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", lastLoggedIn=").append(lastLoggedIn);
        sb.append('}');
        return sb.toString();
    }
}
