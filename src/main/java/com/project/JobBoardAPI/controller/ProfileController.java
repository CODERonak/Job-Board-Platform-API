package com.project.JobBoardAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.JobBoardAPI.dto.profile.*;
import com.project.JobBoardAPI.service.impl.ProfileServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
public class ProfileController {
    private final ProfileServiceImpl profileService;

    // Create a new profile
    // saves the profile and returns the profile details
    // returns a 201 status code
    @PostMapping("/create")
    public ResponseEntity<ProfileResponse> register(@RequestBody @Valid ProfileRequest profileRequest) {
        ProfileResponse response = profileService.createProfile(profileRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
