package com.project.JobBoardAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.JobBoardAPI.model.entity.Profile;
import com.project.JobBoardAPI.model.enums.EmploymentStatus;

/*
 * Repository for Profile entity
 * The repo has the following methods:
 *   boolean existsByUser_Id(Long userId);
 *   Optional<Profile> findByUser_Id(Long userId);
 *   List<Profile> findByEmploymentStatus(EmploymentStatus status);
 *   List<Profile> findByCity(String city);
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByUser_Id(Long userId);

    Optional<Profile> findByUser_Id(Long userId);

    List<Profile> findByEmploymentStatus(EmploymentStatus status);

    List<Profile> findByCity(String city);
}