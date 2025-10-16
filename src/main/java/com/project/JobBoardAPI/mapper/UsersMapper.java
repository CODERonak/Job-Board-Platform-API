package com.project.JobBoardAPI.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.JobBoardAPI.dto.users.*;
import com.project.JobBoardAPI.model.entity.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    // Maps RegisterRequest to Users entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Users toEntity(RegisterRequest request);

    // Maps Users entity to RegisterResponse
    @Mapping(target = "token", ignore = true)
    RegisterResponse toRegisterResponse(Users entity);

    // Maps Users entity to LoginResponse
    @Mapping(target = "token", ignore = true)
    LoginResponse toLoginResponse(Users entity);
}
