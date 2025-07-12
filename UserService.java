package com.swapplatform.service;

import com.swapplatform.dto.UserProfileDTO;
import com.swapplatform.entity.User;
import com.swapplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserProfileDTO getUserProfile(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfileDTO dto = new UserProfileDTO();
        dto.setName(user.getName());
        dto.setLocation(user.getLocation());
        dto.setProfilePhoto(user.getProfilePhoto());
        dto.setPublic(user.isPublic());
        dto.setAvailability(user.getAvailability());
        // Map skills (simplified)
        dto.setSkillsOffered(user.getSkillsOffered().stream().map(SkillOffered::getName).toList());
        dto.setSkillsWanted(user.getSkillsWanted().stream().map(SkillWanted::getName).toList());
        return dto;
    }

    public UserProfileDTO createUser(UserProfileDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setLocation(dto.getLocation());
        user.setProfilePhoto(dto.getProfilePhoto());
        user.setPublic(dto.isPublic());
        user.setAvailability(dto.getAvailability());
        user = userRepository.save(user);
        return getUserProfile(user.getId());
    }
}