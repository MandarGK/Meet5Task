package controller.service;


import controller.model.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BulkDataInsertionService {
    public void insertBulkData(Connection connection, List<UserProfile> profiles) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO user_profiles (user_id, username, age) VALUES (?, ?, ?)")) {

            for (UserProfile profile : profiles) {
                preparedStatement.setLong(1, profile.getUserId());
                preparedStatement.setString(2, profile.getName());
                preparedStatement.setInt(3, profile.getAge());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        }
    }
}
