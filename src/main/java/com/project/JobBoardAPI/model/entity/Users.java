package com.project.JobBoardAPI.model.entity;

import java.time.Instant;

import com.project.JobBoardAPI.model.enums.Role;

import jakarta.persistence.*;
import lombok.Data;

/*
 * Entity for the `users` table in the database.
 * The entity consists of the fields like id, full name, email, password,  role, createdAt
 */

@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

}
