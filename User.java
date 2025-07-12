package com.swapplatform.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
private String role = "USER"; // Add to User.java

    @Column(nullable = false)
    private String name;

    private String location; // Optional
    private String profilePhoto; // Optional
    private boolean isPublic = true;
    private String availability; // e.g., "Weekends, Evenings"
    private boolean isBanned = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SkillOffered> skillsOffered;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SkillWanted> skillsWanted;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getProfilePhoto() { return profilePhoto; }
    public void setProfilePhoto(String profilePhoto) { this.profilePhoto = profilePhoto; }
    public boolean isPublic() { return isPublic; }
    public void setPublic(boolean isPublic) { this.isPublic = isPublic; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
    public boolean isBanned() { return isBanned; }
    public void setBanned(boolean banned) { isBanned = banned; }
    public List<SkillOffered> getSkillsOffered() { return skillsOffered; }
    public void setSkillsOffered(List<SkillOffered> skillsOffered) { this.skillsOffered = skillsOffered; }
    public List<SkillWanted> getSkillsWanted() { return skillsWanted; }
    public void setSkillsWanted(List<SkillWanted> skillsWanted) { this.skillsWanted = skillsWanted; }
}