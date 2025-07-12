package com.swapplatform.controller;

import com.swapplatform.entity.AdminLog;
import com.swapplatform.entity.SkillOffered;
import com.swapplatform.entity.User;
import com.swapplatform.repository.AdminLogRepository;
import com.swapplatform.repository.SkillOfferedRepository;
import com.swapplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SkillOfferedRepository skillOfferedRepository;
    @Autowired
    private AdminLogRepository adminLogRepository;

    @PostMapping("/ban-user/{userId}")
    public ResponseEntity<String> banUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPublicProfile(false); // Or add isBanned field to users table
        userRepository.save(user);
        AdminLog log = new AdminLog();
        log.setAction("Banned user ID: " + userId);
        adminLogRepository.save(log);
        return ResponseEntity.ok("User banned");
    }

    @DeleteMapping("/reject-skill/{skillId}")
    public ResponseEntity<String> rejectSkill(@PathVariable Long skillId) {
        SkillOffered skill = skillOfferedRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
        skillOfferedRepository.delete(skill);
        AdminLog log = new AdminLog();
        log.setAction("Rejected skill ID: " + skillId);
        adminLogRepository.save(log);
        return ResponseEntity.ok("Skill rejected");
    }
}