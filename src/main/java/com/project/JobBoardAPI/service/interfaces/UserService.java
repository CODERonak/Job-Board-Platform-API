package com.project.JobBoardAPI.service.interfaces;

import com.project.JobBoardAPI.dto.users.*;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);
}
