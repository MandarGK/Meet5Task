package controller.service;

import controller.model.ProfileVisit;
import controller.model.UserLike;
import controller.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInteractionService {

    private final Map<Long, UserProfile> userProfiles = new HashMap<>();

    private final List<ProfileVisit> profileVisits = new ArrayList<>();

    private final List<UserLike > userLikes = new ArrayList<>();

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void createUserProfile(UserProfile userProfile) {
        // Add validation logic if needed
        userProfiles.put(userProfile.getUserId(), userProfile);
    }

    public void recordUserVisit(Long visitorId, Long visitedUserId) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        UserProfile visitorProfile = userProfiles.get(visitorId);
        UserProfile visitedUserProfile = userProfiles.get(visitedUserId);

        // Check if both profiles exist
        if (visitorProfile == null || visitedUserProfile == null) {
            throw new IllegalArgumentException("Invalid visitorId or visitedUserId");
        }

        // Assuming you are using Spring JDBC template for simplicity
        String sql = "INSERT INTO ProfileVisits (visitor_id, visited_user_id, visit_timestamp) VALUES (?, ?, ?)";

        LocalDateTime visitTimestamp = LocalDateTime.now();

        // Use JDBC template to execute the SQL query
        int insert = jdbcTemplate.update(sql, visitorId, visitedUserId, visitTimestamp);
        System.out.println("Query Response-->" + insert);


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

        // Assuming you are using Spring JDBC template for simplicity
        String sql = "INSERT INTO UserLikes (like_id, liker_id, liked_user_id, like_timestamp) VALUES (?, ?, ?, ?)";

        LocalDateTime likeTimestamp = LocalDateTime.now();

        // Use JDBC template to execute the SQL query
        jdbcTemplate.update(sql, likerId, likedUserId, likeTimestamp);


        // Record the like
        UserLike userLike = new UserLike();
        userLike.setLikeId(likerId);
        userLike.setLikedUserId(likedUserId);
        userLike.setLikeTimestamp(LocalDateTime.now());
        // Userlike userLike = UserLike.builder().likeId(likerId).likedUserId(likedUserId).likeTimestamp(LocalDateTime.now()).build();
        userLikes.add(userLike);
    }
}
