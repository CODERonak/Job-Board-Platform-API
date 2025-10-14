package com.project.JobBoardAPI.dto.users;

import lombok.Data;

// DTO for register response
@Data
public class RegisterResponse {
    private String fullName;

    private String email;

    private String role;

    private String createdAt;

    private String token;
}
