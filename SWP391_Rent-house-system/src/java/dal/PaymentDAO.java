/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;


public class PaymentDAO {
    DBContext db=new DBContext();
    
     public User getUserByID(int userID) {
        User user = null;

        try {
         String query = "SELECT * FROM User WHERE UserID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setFullName(resultSet.getString("FullName"));
                user.setEmail(resultSet.getString("Email"));
                user.setEmailID(resultSet.getString("EmailID"));
                user.setPassword(resultSet.getString("Password"));
                user.setPhone(resultSet.getString("Phone"));
                user.setDateOfBirth(resultSet.getString("DOB"));
                user.setAddress(resultSet.getString("Address"));
                user.setAvatar(resultSet.getString("Avatar"));
                user.setRoleID(resultSet.getInt("RoleID"));
                user.setManagerID(resultSet.getInt("ManagerID"));
                user.setStatus(resultSet.getBoolean("Status"));
                user.setDescription(resultSet.getString("Description"));
                user.setBalance(resultSet.getInt("Balance"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
     
     public void updateBalance(int userID, int newBalance) {
        try {
            String query = "UPDATE User SET balance = ? WHERE UserID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, newBalance);
            statement.setInt(2, userID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public boolean checkUserPassword(int userID, String password) {
        try {
            String query = "SELECT COUNT(*) FROM User WHERE UserID = ? AND Password = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, userID);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
