package com.project.JobBoardAPI.model.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.Data;

/*
 * Represents a company entity
 *  The entity consists of the fields like id, name, website, location, industry, description, logoUrl, employerId, verified, createdAt
 */
@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "location")
    private String location;

    @Column(name = "industry")
    private String industry;

    @Column(name = "description")
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Long employerId;

    @Column(name = "verified")
    private Boolean verified;

    @Column(name = "created_at")
    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

}
