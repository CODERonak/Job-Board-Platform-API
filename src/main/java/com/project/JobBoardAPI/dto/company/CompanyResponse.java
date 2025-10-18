package com.project.JobBoardAPI.dto.company;

import lombok.Data;

// Represents a company response
@Data
public class CompanyResponse {
    private Long companyId;

    private String name;

    private String description;

    private String website;

    private String location;

    private String industry;

    private boolean verified;

    private String logoUrl;

    private Long createdAt;
}
