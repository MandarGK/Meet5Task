package controller.service;

import controller.model.ProfileVisit;
import controller.model.UserLike;
import controller.model.UserProfile;

import java.time.LocalDateTime;
import java.util.List;

public class FraudDetectionService {
    private static final int MAX_VISITS_LIKES_THRESHOLD = 100;
    private static final int TIME_WINDOW_IN_MINUTES = 10;

    public boolean isFraudulentActivity(UserProfile user, List<ProfileVisit> visits, List<UserLike> likes) {
        // Assuming that visits and likes have timestamps
        LocalDateTime now = LocalDateTime.now();

        long recentVisits = visits.stream()
                .filter(visit -> now.minusMinutes(TIME_WINDOW_IN_MINUTES).isBefore(visit.getVisitTimestamp()))
                .count();

        long recentLikes = likes.stream()
                .filter(like -> now.minusMinutes(TIME_WINDOW_IN_MINUTES).isBefore(like.getLikeTimestamp()))
                .count();

        return (recentVisits + recentLikes) > MAX_VISITS_LIKES_THRESHOLD;
    }
}
