package com.swapplatform.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserProfileDTO {
    @NotBlank(message = "Name is required")
    private String name;
    private String location;
    private String profilePhoto;
    private boolean isPublic;
    private String availability;
    private List<String> skillsOffered;
    private List<String> skillsWanted;

    // Getters and setters
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
    public List<String> getSkillsOffered() { return skillsOffered; }
    public void setSkillsOffered(List<String> skillsOffered) { this.skillsOffered = skillsOffered; }
    public List<String> getSkillsWanted() { return skillsWanted; }
    public void setSkillsWanted(List<String> skillsWanted) { this.skillsWanted = skillsWanted; }
}