package com.project.JobBoardAPI.dto.profile;

import java.time.LocalDate;

import com.project.JobBoardAPI.model.enums.EmploymentStatus;

import lombok.Data;

@Data
public class ProfileResponse {
    private Long id;

    private Long userId;

    private String headline;

    private String city;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String bio;

    private EmploymentStatus employmentStatus;

    private String resumePath;

    private String skills;
}
