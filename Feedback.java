package com.swapplatform.entity;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "swap_request_id")
    private SwapRequest swapRequest;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int rating; // 1-5
    private String comment;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SwapRequest getSwapRequest() { return swapRequest; }
    public void setSwapRequest(SwapRequest swapRequest) { this.swapRequest = swapRequest; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}