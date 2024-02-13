package controller.service;

import controller.model.ProfileVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProfileVisitService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileVisitService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProfileVisit> getProfileVisitsForUser(Long userId) {
        String sql = "SELECT vp.visitor_id, up.username AS visitor_username, vp.visit_timestamp " +
                "FROM profile_visits vp " +
                "JOIN user_profiles up ON vp.visitor_id = up.user_id " +
                "WHERE vp.visited_user_id = ? " +
                "ORDER BY vp.visit_timestamp DESC";

        return jdbcTemplate.query(sql, new Object[]{userId}, this::mapRowToProfileVisit);
    }

    private ProfileVisit mapRowToProfileVisit(ResultSet rs, int rowNum) throws SQLException {
        ProfileVisit profileVisit = new ProfileVisit();
        profileVisit.setVisitorId(rs.getLong("visitor_id"));
        profileVisit.setVisitorUsername(rs.getString("visitor_username"));
        profileVisit.setVisitTimestamp(rs.getTimestamp("visit_timestamp").toLocalDateTime());
        return profileVisit;
    }
}
