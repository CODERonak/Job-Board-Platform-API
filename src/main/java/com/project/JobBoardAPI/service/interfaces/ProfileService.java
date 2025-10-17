package com.project.JobBoardAPI.service.interfaces;

import java.util.List;

import com.project.JobBoardAPI.dto.profile.*;
import com.project.JobBoardAPI.model.enums.EmploymentStatus;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest profileRequest);

    ProfileResponse getProfile(Long id);

    ProfileResponse updateProfile(Long id, ProfileRequest profileRequest);

    List<ProfileResponse> findProfileByEmploymentStatus(EmploymentStatus employmentStatus);

    List<ProfileResponse> findProfileByCity(String city);
}
