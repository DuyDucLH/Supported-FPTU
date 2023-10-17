package models;
public class Notification {
    private int notificationID;
    private int userID;
    private String tDate;
    private String description;

    public Notification() {
    }

    public Notification(int userID, String tDate, String description) {
        this.userID = userID;
        this.tDate = tDate;
        this.description = description;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTDate() {
        return tDate;
    }

    public void setTDate(String tDate) {
        this.tDate = tDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}