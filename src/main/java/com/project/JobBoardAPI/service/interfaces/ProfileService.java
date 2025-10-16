package com.project.JobBoardAPI.service.interfaces;

import com.project.JobBoardAPI.dto.profile.*;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest profileRequest);

    ProfileResponse getProfile(Long id);

    ProfileResponse updateProfile(Long id, ProfileRequest profileRequest);
}
