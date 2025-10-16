package com.project.JobBoardAPI.model.entity;

import java.time.LocalDate;

import com.project.JobBoardAPI.model.enums.EmploymentStatus;

import jakarta.persistence.*;
import lombok.Data;

/*
 * Entity for the `profiles` table in the database.
 * The entity consists of the fields like id, userId, headline, city, phoneNumber, bio, resumePath, skills.
 */

@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "headline")
    private String headline;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "phone_number")
    private String phoneNumber;

    private LocalDate dateOfBirth;

    @Lob
    @Column(name = "bio")
    private String bio;

    @Column(name = "employment_status")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Column(name = "skills")
    private String skills;
}
