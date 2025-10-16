package com.project.JobBoardAPI.service.impl;

import org.springframework.stereotype.Service;

import com.project.JobBoardAPI.dto.profile.ProfileRequest;
import com.project.JobBoardAPI.dto.profile.ProfileResponse;
import com.project.JobBoardAPI.service.interfaces.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProfile'");
    }

    @Override
    public ProfileResponse getProfile(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProfile'");
    }

    @Override
    public ProfileResponse updateProfile(Long id, ProfileRequest profileRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    }
    
}
