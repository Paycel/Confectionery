package com.mirea.confectionery.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NonNull
    @Column(name = "username")
    private String name;
    @NonNull
    @Column(name = "password")
    private String password;
    @NonNull
    @Column(name = "email")
    private String email;
}
