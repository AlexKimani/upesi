package com.upesi.upesiauthserver.core.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jboss.aerogear.security.otp.api.Base32;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tbl_user_account")
public class User extends AbstractValues {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    @Column(length = 60)
    private String password;
    private boolean enabled;
    private boolean isUsing2FA;
    private String secret;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
        super();
        this.secret = Base32.random();
        this.enabled = false;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [id=")
                .append(id)
                .append(", firstName=").append(firstName)
                .append(", lastName=").append(lastName)
                .append(", phoneNumber=").append(phoneNumber)
                .append(", email=").append(email)
                .append(", enabled=").append(enabled)
                .append(", isUsing2FA=").append(isUsing2FA)
                .append(", secret=").append(secret)
                .append(", roles=").append(roles)
                .append("]");
        return builder.toString();
    }
}