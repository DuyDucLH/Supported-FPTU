package models;

import java.util.Date;

public class Transaction {
    private int transactionID;
    private int userID;
    private String tDate;
    private int amount;
    private String bankNumber;
    private int tStatus;

    public Transaction() {
        // Default constructor
    }

    public Transaction(int transactionID, int userID, String tDate, int amount, String bankNumber, int tStatus) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.tDate = tDate;
        this.amount = amount;
        this.bankNumber = bankNumber;
        this.tStatus = tStatus;
    }

    public Transaction(int userID, String tDate, int amount, String bankNumber, int tStatus) {
        this.userID = userID;
        this.tDate = tDate;
        this.amount = amount;
        this.bankNumber = bankNumber;
        this.tStatus = tStatus;
    }
    

    // Getters and setters for all the fields

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public int getTStatus() {
        return tStatus;
    }

    public void setTStatus(int tStatus) {
        this.tStatus = tStatus;
    }
}