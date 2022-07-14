package com.example.proj.action;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport{
    
    private int accountId;
    private String accountDeleted;
   

    // / method for delete the record
	public String execute() throws Exception{
        // HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        // accountId = Integer.parseInt(request.getParameter(accountId));
        Connection connection = null;
        PreparedStatement preparedStatement = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "DELETE FROM accounts WHERE account_id ='"+accountId+"'";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                setAccountDeleted("Account deleted.");
                return SUCCESS;
            }
		} catch (Exception e) {

        } finally {
           if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
           if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }

        return ERROR;


	}


    public int getAccountId() {
        return accountId;
    }


    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    public String getAccountDeleted() {
        return accountDeleted;
    }


    public void setAccountDeleted(String accountDeleted) {
        this.accountDeleted = accountDeleted;
    }


    
}
