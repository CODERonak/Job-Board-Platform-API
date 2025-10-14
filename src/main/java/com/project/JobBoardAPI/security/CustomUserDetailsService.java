package com.project.JobBoardAPI.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.JobBoardAPI.UsersRepository;
import com.project.JobBoardAPI.model.entity.Users;

import lombok.AllArgsConstructor;

// Custom user details service for Spring Security
// It loads user details from the database based on the provided email
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(user);
    }

}
