package com.smartshopai.smartshopbackend.controller;

import com.smartshopai.smartshopbackend.dto.LoginRequest;
import com.smartshopai.smartshopbackend.dto.LoginResponse;
import com.smartshopai.smartshopbackend.dto.RegisterRequest;
import com.smartshopai.smartshopbackend.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return "Registered successfully";
    }
}
