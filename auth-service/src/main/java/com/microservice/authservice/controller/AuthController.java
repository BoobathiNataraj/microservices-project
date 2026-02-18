package com.microservice.authservice.controller;

import com.microservice.authservice.dto.LoginRequest;
import com.microservice.authservice.dto.RegisterRequest;
import com.microservice.authservice.entity.AuthUser;
import com.microservice.authservice.service.AuthService;
import com.microservice.authservice.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

   
    @PostMapping("/register")
    public AuthUser register(@RequestBody RegisterRequest request) {
        return authService.register(request.getUsername(), request.getPassword());
    }

    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        AuthUser user = authService.validateUser(
                request.getUsername(),
                request.getPassword()
        );

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}
