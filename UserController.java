package SkillSwap.skill.controller;



import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import SkillSwap.skill.model.User;
import SkillSwap.skill.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String rootRedirect() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/api/users/login")
    public String login(@ModelAttribute User user, Model model) {
        User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
            model.addAttribute("users", userService.getAllUsers().stream()
                .filter(u -> "Public".equals(u.getProfileVisibility()))
                .collect(Collectors.toList()));
            return "index"; // Direct render instead of redirect to ensure model persists
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/api/users/register")
    public String register(@ModelAttribute User user, Model model) {
        User existingUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (existingUser == null) {
            userService.registerUser(user);
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Email already registered");
            return "register";
        }
    }

    @GetMapping("/index")
    public String homePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            String email = auth.getName(); // Get email from authentication
            User loggedInUser = userService.findByEmail(email);
            if (loggedInUser != null) {
                model.addAttribute("user", loggedInUser);
            } else {
                model.addAttribute("user", null); // Fallback if user not found
            }
        } else {
            model.addAttribute("user", null);
        }
        model.addAttribute("users", userService.getAllUsers().stream()
            .filter(u -> "Public".equals(u.getProfileVisibility()))
            .collect(Collectors.toList()));
        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPages", 1); // Placeholder, implement pagination logic
        return "index";
    }
}