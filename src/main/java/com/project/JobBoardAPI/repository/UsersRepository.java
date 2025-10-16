package com.project.JobBoardAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.JobBoardAPI.model.entity.Users;

/*
 * Repository for Users entity
 * The repo has the following methods:
 * Optional<User> findByEmail(String email)
 * boolean existsByEmail(String email)
 */

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);
}
