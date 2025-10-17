package com.project.JobBoardAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.JobBoardAPI.dto.profile.*;
import com.project.JobBoardAPI.model.enums.EmploymentStatus;
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

    // find profiles by employment status
    // returns a 200 status code
    @GetMapping("emp/{employmentStatus}")
    public ResponseEntity<List<ProfileResponse>> findProfileByEmpStatus(
            @PathVariable EmploymentStatus employmentStatus) {
        List<ProfileResponse> response = profileService.findProfileByEmploymentStatus(employmentStatus);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // find profiles by city
    // returns a 200 status code
    @GetMapping("city/{cityName}")
    public ResponseEntity<List<ProfileResponse>> findProfileByCity(@PathVariable String cityName) {
        List<ProfileResponse> response = profileService.findProfileByCity(cityName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
