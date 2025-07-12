package com.swapplatform.entity;

import javax.persistence.*;

@Entity
public class SkillOffered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // e.g., "Photoshop"

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}