package com.swapplatform.controller;

import com.swapplatform.dto.UserProfileDTO;
import com.swapplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUser(@Valid @RequestBody UserProfileDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }
}