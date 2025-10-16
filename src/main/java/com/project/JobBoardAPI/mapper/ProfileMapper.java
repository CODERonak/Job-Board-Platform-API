package com.project.JobBoardAPI.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.JobBoardAPI.dto.profile.*;
import com.project.JobBoardAPI.model.entity.Profile;
import com.project.JobBoardAPI.model.entity.Users;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    // Maps ProfileRequest to Profile entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user") // Maps user field
    Profile toEntity(ProfileRequest request, Users user);

    // Maps Profile entity to ProfileResponse
    @Mapping(source = "user.id", target = "userId")
    ProfileResponse toResponse(Profile profile);

    // Maps list of Profile entities to list of ProfileResponse
    List<ProfileResponse> toResponseList(List<Profile> profiles);
}