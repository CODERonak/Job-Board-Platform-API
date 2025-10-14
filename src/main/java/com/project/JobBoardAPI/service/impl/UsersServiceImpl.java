package com.project.JobBoardAPI.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.JobBoardAPI.UsersRepository;
import com.project.JobBoardAPI.dto.users.LoginRequest;
import com.project.JobBoardAPI.dto.users.LoginResponse;
import com.project.JobBoardAPI.dto.users.RegisterRequest;
import com.project.JobBoardAPI.dto.users.RegisterResponse;
import com.project.JobBoardAPI.mapper.UsersMapper;
import com.project.JobBoardAPI.model.entity.Users;
import com.project.JobBoardAPI.model.enums.Role;
import com.project.JobBoardAPI.security.jwt.JWTUtil;
import com.project.JobBoardAPI.service.interfaces.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UserService {
   private final UsersRepository usersRepository;
   private final UsersMapper usersMapper;
   private final BCryptPasswordEncoder passwordEncoder;
   private final JWTUtil jwtUtil;
   private final AuthenticationManager authenticationManager;

   @Override
   public RegisterResponse register(RegisterRequest registerRequest) {
      Users user = usersMapper.toEntity(registerRequest);

      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRole(Role.EMPLOYER);
      Users savedUser = usersRepository.save(user);
   
      String jwtToken = jwtUtil.generateToken(savedUser.getEmail());

      RegisterResponse response = usersMapper.toRegisterResponse(savedUser);
      response.setToken(jwtToken);

      return response;
   }

   @Override
   public LoginResponse login(LoginRequest loginRequest) {
       try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()));

                            // sets the authentication
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtUtil.generateToken(loginRequest.getEmail());

            // finds the user by email
            Users loggedInUser = usersRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            LoginResponse response = usersMapper.toLoginResponse(loggedInUser);

            response.setToken(jwtToken);

            return response;

            // if authentication fails, throws an exception
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
   }

}
