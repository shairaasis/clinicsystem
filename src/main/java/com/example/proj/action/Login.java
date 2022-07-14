package com.example.proj.action;
import com.example.proj.model.*;
import java.sql.PreparedStatement;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
    public String errorMessage;
    private String encryptedPassword; 
    private String token;


    private static Account accountBean;

    public String execute() throws Exception {
        accountBean = getAccountBean();
        if(validate(accountBean.getUsername(), accountBean.getPassword())){  

            if(accountBean.getAccountType() == 1){
                return "admin";
            }else if(accountBean.getAccountType() == 2){
                return "veterinarian";

            }else{
                return "client";
            }
        }  
        else{  
            errorMessage = "Login failed. Username and/or password is incorrect.";
            return "error";  
        } 
    }
    public boolean validate (String username,String password){  
        boolean status=false;  
         try{  
          Class.forName("com.mysql.jdbc.Driver");  
          Connection con=DriverManager.getConnection(  
          "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC","root","password");  
          setEncryptedPassword(encryptMD5(accountBean.getPassword()));
          PreparedStatement ps=con.prepareStatement(  
            "select * from accounts where username=? and password=?");  
          ps.setString(1,username);  
          ps.setString(2,encryptedPassword);  
          ResultSet rs=ps.executeQuery();
          status=rs.next();   
            accountBean.setAccountId(rs.getInt(1));
            accountBean.setAccountType(rs.getInt(2));
            accountBean.setUsername(rs.getString(3));
            accountBean.setLastName(rs.getString(6));   
            accountBean.setFirstName(rs.getString(5)); 
            accountBean.setEmail(rs.getString(9));
         }catch(Exception e){e.printStackTrace();}  
        return status;  
    } 
    private String encryptMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder s = new StringBuilder();  
        for(int i=0; i<  hash.length; i++)  
        {  
                s.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));  
        }  
        encryptedPassword = s.toString();
        return encryptedPassword;
    }

    
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public Account getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(Account accountBean) {
        Login.accountBean = accountBean;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
}