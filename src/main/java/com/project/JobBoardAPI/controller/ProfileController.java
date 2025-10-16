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

    // gets a profile by id
    // returns a 200 status code
    @GetMapping("/get/{profileId}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable Long profileId) {
        ProfileResponse response = profileService.getProfile(profileId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // updates a profile
    // returns a 200 status code
    @PutMapping("/update/{id}")
    public ResponseEntity<ProfileResponse> updateProfile(@PathVariable Long id,
            @Valid @RequestBody ProfileRequest profileRequest) {
        ProfileResponse response = profileService.updateProfile(id, profileRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
