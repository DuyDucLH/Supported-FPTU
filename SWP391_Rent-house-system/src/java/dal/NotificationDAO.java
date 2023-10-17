/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Notification;


public class NotificationDAO {
    DBContext db=new DBContext();
    public void createNotification(Notification notification) {
        try {
            String query = "INSERT INTO [Notification] (UserID, TDate, Description) VALUES (?, ?, ?)";
            PreparedStatement statement = db.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, notification.getUserID());
            statement.setString(2, notification.getTDate());
            statement.setString(3, notification.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating notification failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    notification.setNotificationID(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating notification failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Notification getNotificationByID(int notificationID) {
        Notification notification = null;

        try {
            String query = "SELECT * FROM [Notification] WHERE NotificationID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, notificationID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                notification = mapResultSetToNotification(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notification;
    }

    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();

        try {
            String query = "SELECT * FROM Notification";
            PreparedStatement statement = db.connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Notification notification = mapResultSetToNotification(resultSet);
                notifications.add(notification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public void updateNotification(Notification notification) {
        try {
            String query = "UPDATE Notification SET UserID = ?, TDate = ?, Description = ? WHERE NotificationID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, notification.getUserID());
            statement.setString(2, notification.getTDate());
            statement.setString(3, notification.getDescription());
            statement.setInt(4, notification.getNotificationID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNotification(int notificationID) {
        try {
            String query = "DELETE FROM Notification WHERE NotificationID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, notificationID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Notification mapResultSetToNotification(ResultSet resultSet) throws SQLException {
        Notification notification = new Notification();
        notification.setNotificationID(resultSet.getInt("NotificationID"));
        notification.setUserID(resultSet.getInt("UserID"));
        notification.setTDate(resultSet.getString("TDate"));
        notification.setDescription(resultSet.getString("Description"));
        return notification;
    }
}
