package com.swapplatform.controller;

import com.swapplatform.dto.LoginRequest;
import com.swapplatform.entity.User;
import com.swapplatform.service.AuthService;
import com.swapplatform.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody LoginRequest request) {
        User user = authService.register(request);
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {
        User user = authService.login(request);
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(token);
    }
}