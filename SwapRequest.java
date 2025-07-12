package com.swapplatform.entity;

import javax.persistence.*;

@Entity
public class SwapRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "skill_offered_id")
    private SkillOffered skillOffered;

    @ManyToOne
    @JoinColumn(name = "skill_wanted_id")
    private SkillWanted skillWanted;

    @Enumerated(EnumType.STRING)
    private SwapStatus status; // PENDING, ACCEPTED, REJECTED, DELETED

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getRequester() { return requester; }
    public void setRequester(User requester) { this.requester = requester; }
    public User getReceiver() { return receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }
    public SkillOffered getSkillOffered() { return skillOffered; }
    public void setSkillOffered(SkillOffered skillOffered) { this.skillOffered = skillOffered; }
    public SkillWanted getSkillWanted() { return skillWanted; }
    public void setSkillWanted(SkillWanted skillWanted) { this.skillWanted = skillWanted; }
    public SwapStatus getStatus() { return status; }
    public void setStatus(SwapStatus status) { this.status = status; }
}

enum SwapStatus {
    PENDING, ACCEPTED, REJECTED, DELETED
}