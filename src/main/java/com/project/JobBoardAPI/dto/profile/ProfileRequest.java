package com.project.JobBoardAPI.dto.profile;

import java.time.LocalDate;

import com.project.JobBoardAPI.model.enums.EmploymentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileRequest {

    @NotBlank(message = "Headline cannot be empty.")
    @Size(max = 255, message = "Headline must be less than 255 characters.")
    private String headline;

    @NotBlank(message = "City cannot be empty.")
    @Size(max = 50, message = "City must be less than 50 characters.")
    private String city;

    @NotBlank(message = "Phone number is required.")
    @Size(max = 10, message = "Phone number must be exactly 10 digits.")
    private String phoneNumber;

    @NotNull(message = "Date of Birth is mandatory.")
    @Past(message = "Date of Birth must be in the past.")
    private LocalDate dateOfBirth;

    @Size(max = 5000, message = "Bio must be less than 5000 characters.")
    private String bio;

    @NotNull(message = "Employment Status is mandatory.")
    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    @Size(message = "Resume URL is a must.")
    private String resumeUrl;

    @Size(max = 500, message = "Skills string must be less than 500 characters.")
    private String skills;
}
