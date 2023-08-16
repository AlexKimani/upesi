package com.upesi.upesiauthserver.core.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tbl_user_location")
public class UserLocation extends AbstractValues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private boolean enabled;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public UserLocation() {
        super();
        enabled = false;
    }

    public UserLocation(String country, User user) {
        super();
        this.country = country;
        this.user = user;
        enabled = false;
    }

    @Override
    public String toString() {
        return "UserLocation [id=" + id + ", country=" + country + ", enabled=" + enabled + ", user=" + user + "]";
    }

}
