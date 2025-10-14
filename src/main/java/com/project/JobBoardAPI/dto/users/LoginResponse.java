package com.project.JobBoardAPI.dto.users;

import lombok.Data;

// DTO for user login response
@Data
public class LoginResponse {
    private String email;

    private String role;

    private String token;
}
