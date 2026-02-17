package com.microservice.authservice.service;

import com.microservice.authservice.entity.AuthUser;
import com.microservice.authservice.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register user
    public AuthUser register(String username, String password) {
     
        AuthUser user = AuthUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))  //  encrypt
                .role("ROLE_USER")
                .build();

        return authUserRepository.save(user);
    }

    // Validate login
    public AuthUser validateUser(String username, String rawPassword) {

    	AuthUser user = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

       

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");   
        }

        return user; 
    }

}
