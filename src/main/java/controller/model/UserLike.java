package controller.model;

import java.time.LocalDateTime;

public class UserLike {

    private Long likeId;
    private Long likerId;
    private Long likedUserId;
    private LocalDateTime likeTimestamp;

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "UserLike{" +
                "likeId='" + likeId + '\'' +
                "likerId='" + likerId + '\'' +
                "likedUserId='" + likedUserId + '\'' +
                "likeTimestamp='" + likeTimestamp + '\'' +

                '}';
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Long getLikerId() {
        return likerId;
    }

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }

    public Long getLikedUserId() {
        return likedUserId;
    }

    public void setLikedUserId(Long likedUserId) {
        this.likedUserId = likedUserId;
    }

    public LocalDateTime getLikeTimestamp() {
        return likeTimestamp;
    }

    public void setLikeTimestamp(LocalDateTime likeTimestamp) {
        this.likeTimestamp = likeTimestamp;
    }
}

