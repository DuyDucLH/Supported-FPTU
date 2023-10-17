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
import models.Transaction;



public class TransactionDAO {
    DBContext db=new DBContext();
    public void createTransaction(Transaction transaction) {
        try {
            String query = "INSERT INTO [dbo].[Transaction] (UserID, TDate, amount, BankNumber, TStatus) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, transaction.getUserID());
            statement.setString(2, transaction.getTDate());
            statement.setInt(3, transaction.getAmount());
            statement.setString(4, transaction.getBankNumber());
            statement.setInt(5, transaction.getTStatus());
            statement.executeUpdate();
            if(transaction.getTStatus()==1){
                updateUserBalance(transaction.getUserID(),transaction.getAmount());
            }else{
                updateUserBalanceMinus(transaction.getUserID(),transaction.getAmount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public Transaction getTransactionByID(int transactionID) {
        Transaction transaction = null;

        try {
            String query = "SELECT * FROM Transaction WHERE TransactionID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, transactionID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                transaction = mapResultSetToTransaction(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try {
            String query = "SELECT * FROM Transaction";
            Statement statement = db.connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Transaction transaction = mapResultSetToTransaction(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public void updateTransaction(Transaction transaction) {
        try {
            String query = "UPDATE Transaction SET UserID = ?, TDate = ?, amount = ?, BankNumber = ?, TStatus = ? WHERE TransactionID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, transaction.getUserID());
            statement.setString(2, transaction.getTDate());
            statement.setInt(3, transaction.getAmount());
            statement.setString(4, transaction.getBankNumber());
            statement.setInt(5, transaction.getTStatus());
            statement.setInt(6, transaction.getTransactionID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(int transactionID) {
        try {
            String query = "DELETE FROM Transaction WHERE TransactionID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, transactionID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Transaction mapResultSetToTransaction(ResultSet resultSet) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setTransactionID(resultSet.getInt("TransactionID"));
        transaction.setUserID(resultSet.getInt("UserID"));
        transaction.setTDate(resultSet.getString("TDate"));
        transaction.setAmount(resultSet.getInt("amount"));
        transaction.setBankNumber(resultSet.getString("BankNumber"));
        transaction.setTStatus(resultSet.getInt("TStatus"));
        return transaction;
    }
    public List<Transaction> getTransactionsByUserID(int userID) {
        List<Transaction> transactions = new ArrayList<>();

        try {
            String query = "SELECT * FROM Transaction WHERE UserID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transaction transaction = mapResultSetToTransaction(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }
    public void updateUserBalance(int userID, int amountToAdd) {
        try {
            String query = "UPDATE [dbo].[User] SET balance = balance + ? WHERE UserID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, amountToAdd);
            statement.setInt(2, userID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUserBalanceMinus(int userID, int amountToAdd) {
        try {
            String query = "UPDATE User SET balance = balance - ? WHERE UserID = ?";
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, amountToAdd);
            statement.setInt(2, userID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
