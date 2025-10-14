package com.project.JobBoardAPI.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// DTO for user login request
@Data
public class LoginRequest {

    @Email
    private String email;

    @NotBlank
    private String password;
}
