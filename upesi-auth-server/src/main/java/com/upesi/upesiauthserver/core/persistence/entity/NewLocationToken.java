package com.upesi.upesiauthserver.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(name = "tbl_new_location_token")
public class NewLocationToken extends AbstractValues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @OneToOne(targetEntity = UserLocation.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_location_id")
    private UserLocation userLocation;

    public NewLocationToken() {
        super();
    }

    public NewLocationToken(final String token) {
        super();
        this.token = token;
    }

    public NewLocationToken(final String token, final UserLocation userLocation) {
        super();
        this.token = token;
        this.userLocation = userLocation;
    }
}
