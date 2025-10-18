package com.project.JobBoardAPI.dto.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Represents a company request dto
@Data
public class CompanyRequest {

    @NotBlank(message = "Company name cannot be empty.")
    @Size(max = 255, message = "Company name must be less than 255 characters.")
    private String name;

    @NotBlank(message = "Company description cannot be empty.")
    @Size(max = 1000, message = "Company description must be less than 1000 characters.")
    private String description;

    @NotBlank(message = "Website cannot be empty.")
    private String website;

    @NotBlank(message = "Location cannot be empty.")
    private String location;

    @NotBlank(message = "Industry cannot be empty.")
    private String industry;

    @NotBlank(message = "Logo URL cannot be empty.")
    private String logoUrl;
}