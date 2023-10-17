/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


public class User {
    private int userID;
    private String fullName;
    private String email;
    private String emailID;
    private String password;
    private String phone;
    private String dateOfBirth;
    private String address;
    private String avatar;
    private Integer roleID;
    private Integer managerID;
    private Boolean status;
    private String description;
    private int balance;

    public User(int userID, String fullName, String email, String emailID, String password, String phone, String dateOfBirth, String address, String avatar, Integer roleID, Integer managerID, Boolean status, String description, int balance) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.emailID = emailID;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.avatar = avatar;
        this.roleID = roleID;
        this.managerID = managerID;
        this.status = status;
        this.description = description;
        this.balance = balance;
    }

    public User() {
    }
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
