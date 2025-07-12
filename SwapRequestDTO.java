package com.swapplatform.dto;

import javax.validation.constraints.NotNull;

public class SwapRequestDTO {
    @NotNull(message = "Requester ID is required")
    private Long requesterId;
    @NotNull(message = "Receiver ID is required")
    private Long receiverId;
    @NotNull(message = "Skill offered ID is required")
    private Long skillOfferedId;
    @NotNull(message = "Skill wanted ID is required")
    private Long skillWantedId;

    // Getters and setters
    public Long getRequesterId() { return requesterId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }
    public Long getReceiverId() { return receiverId; }
    public void setReceiverId(Long receiverId) { this.receiverId = receiverId; }
    public Long getSkillOfferedId() { return skillOfferedId; }
    public void setSkillOfferedId(Long skillOfferedId) { this.skillOfferedId = skillOfferedId; }
    public Long getSkillWantedId() { return skillWantedId; }
    public void setSkillWantedId(Long skillWantedId) { this.skillWantedId = skillWantedId; }
}