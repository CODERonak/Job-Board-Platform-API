package com.project.JobBoardAPI.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.JobBoardAPI.dto.profile.ProfileRequest;
import com.project.JobBoardAPI.dto.profile.ProfileResponse;
import com.project.JobBoardAPI.exceptions.custom.AlreadyExistsException;
import com.project.JobBoardAPI.exceptions.custom.NotFoundException;
import com.project.JobBoardAPI.mapper.ProfileMapper;
import com.project.JobBoardAPI.model.entity.Profile;
import com.project.JobBoardAPI.model.entity.Users;
import com.project.JobBoardAPI.repository.*;
import com.project.JobBoardAPI.service.interfaces.ProfileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UsersRepository usersRepository;
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    // creates profile for the authenticated user
    // if the user already has a profile, throws an exception
    // otherwise, saves the profile and returns the response
    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        Users user = getAuthenticatedUser();
        Long verifiedUserId = user.getId();

        if (profileRepository.existsByUser_Id(verifiedUserId)) {
            throw new AlreadyExistsException("Profile already exists you don't need to create another one");
        }

        Profile userProfile = profileMapper.toEntity(profileRequest, user);
        profileRepository.save(userProfile);

        return profileMapper.toResponse(userProfile);
    }

    // gets profile by id
    // if the profile does not exist, throws an exception
    @Override
    public ProfileResponse getProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profile not found"));

        return profileMapper.toResponse(profile);
    }

    // updates profile
    // if the profile does not exist, throws an exception
    // if the user is not the owner of the profile, throws an exception
    @Override
    public ProfileResponse updateProfile(Long id, ProfileRequest profileRequest) {
        Users user = getAuthenticatedUser();
        Long verifiedUserId = user.getId();

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profile not found, please create one"));

        if (!profile.getUser().getId().equals(verifiedUserId))
            throw new RuntimeException("You can only update your own profile");

        profile.setHeadline(profileRequest.getHeadline());
        profile.setCity(profileRequest.getCity());
        profile.setPhoneNumber(profileRequest.getPhoneNumber());
        profile.setDateOfBirth(profileRequest.getDateOfBirth());
        profile.setBio(profileRequest.getBio());
        profile.setEmploymentStatus(profileRequest.getEmploymentStatus());
        profile.setResumeUrl(profileRequest.getResumeUrl());
        profile.setSkills(profileRequest.getSkills());

        Profile savedProfile = profileRepository.save(profile);

        return profileMapper.toResponse(savedProfile);
    }

    // method to get the authenticated user
    private Users getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedUserEmail = auth.getName();

        return usersRepository.findByEmail(authenticatedUserEmail)
                .orElseThrow(() -> new NotFoundException("User not found, register first"));
    }

}
