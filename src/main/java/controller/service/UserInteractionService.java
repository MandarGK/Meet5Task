package controller.service;


import controller.model.ProfileVisit;
import controller.model.UserLike;
import controller.model.UserProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInteractionService {

    private final Map<Long, UserProfile> userProfiles = new HashMap<>();

    private final List<ProfileVisit> profileVisits = new ArrayList<>();

    private final List<UserLike > userLikes = new ArrayList<>();

    public void createUserProfile(UserProfile userProfile) {
        // Add validation logic if needed
        userProfiles.put(userProfile.getUserId(), userProfile);
    }

    public void recordUserVisit(Long visitorId, Long visitedUserId) {
        UserProfile visitorProfile = userProfiles.get(visitorId);
        UserProfile visitedUserProfile = userProfiles.get(visitedUserId);

        // Check if both profiles exist
        if (visitorProfile == null || visitedUserProfile == null) {
            throw new IllegalArgumentException("Invalid visitorId or visitedUserId");
        }

        // Record the visit
        ProfileVisit profileVisit  = new ProfileVisit();
        profileVisit.setVisitId(visitorId);
        profileVisit.setVisitedUserId(visitedUserId);
        profileVisit.setVisitorId(visitorId);
        profileVisit.setVisitTimestamp(LocalDateTime.now());
        profileVisits.add(profileVisit);

    }

    public void recordUserLike(Long likerId, Long likedUserId) {
        UserProfile likerProfile = userProfiles.get(likerId);
        UserProfile likedUserProfile = userProfiles.get(likedUserId);

        // Check if both profiles exist
        if (likerProfile == null || likedUserProfile == null) {
            throw new IllegalArgumentException("Invalid likerId or likedUserId");
        }

        // Record the like
        UserLike userLike = new UserLike();
        userLike.setLikeId(likerId);
        userLike.setLikedUserId(likedUserId);
        userLike.setLikeTimestamp(LocalDateTime.now());
        // Userlike userLike = UserLike.builder().likeId(likerId).likedUserId(likedUserId).likeTimestamp(LocalDateTime.now()).build();
        userLikes.add(userLike);
    }
}
