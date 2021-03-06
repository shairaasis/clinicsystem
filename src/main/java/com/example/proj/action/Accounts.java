package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.proj.model.Account;
import com.opensymphony.xwork2.ActionSupport;

public class Accounts extends ActionSupport{
    
    ArrayList<Account> accounts = new ArrayList<Account>();
    Account account;

    public String execute() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT * FROM accounts ORDER BY last_name ASC";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Account account=new Account();
                    account.setAccountId(rs.getInt(1));
                    account.setUsername(rs.getString(3));
                    account.setLastName(rs.getString(6));   
                    account.setFirstName(rs.getString(5)); 
                    account.setEmail(rs.getString(8));
                    account.setAddress(rs.getString(7));
                    account.setContactNo(rs.getString(9)); 
                    accounts.add(account); 

                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }

    // // / method for delete the record
	// public String delete(int accountId){
    //     Connection connection = null;
    //     PreparedStatement preparedStatement = null;
	// 	try {
	// 		String URL = "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC";
    //         Class.forName("com.mysql.jdbc.Driver");
    //         connection = DriverManager.getConnection(URL, "root", "password");

    //         if (connection != null) {
    //             String sql = "DELETE FROM accounts WHERE account_id =?";
    //             preparedStatement = connection.prepareStatement(sql);
    //             preparedStatement.setInt(1, accountId);
    //             preparedStatement.executeUpdate();
    //             System.out.println("===========ACCOUNT DELETED =========******\n\n\n\n\n\n");
    //             return SUCCESS;
    //         }
	// 	} catch (Exception e) {
    //         return ERROR;
    //     } finally {
    //        if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
    //        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    //     }
    //     return ERROR;
	// }

    
    String getAccountId() {
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getParameter(int accountId) {
        return null;
    }

    
    
}
