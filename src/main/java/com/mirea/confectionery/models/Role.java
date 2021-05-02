package com.mirea.confectionery.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_id")
    @NonNull
    private Long id;

    @Column(name = "role_name")
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}
