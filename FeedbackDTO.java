package com.swapplatform.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FeedbackDTO {
    @NotNull(message = "Swap request ID is required")
    private Long swapRequestId;
    @NotNull(message = "User ID is required")
    private Long userId;
    @Min(1) @Max(5)
    private int rating;
    private String comment;

    // Getters and setters
    public Long getSwapRequestId() { return swapRequestId; }
    public void setSwapRequestId(Long swapRequestId) { this.swapRequestId = swapRequestId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}