package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.proj.model.Pet;
import com.opensymphony.xwork2.ActionSupport;

public class Pets extends ActionSupport{
    private static Pet petBean = new Pet();
    private String error = "Random";
    private String successMessage;
    private int accountId;
        
    public String execute() {
        return SUCCESS;
    }


    public String registerPet() throws Exception{
        
        petBean = getPetBean();
        
        System.out.println("======\n\n "+petBean.getDateOfBirth()+"\n\n===========");
        // String pattern = "MM-dd-yyyy";
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // String dateOfBirth = simpleDateFormat.format(new Date());
        // dateOfBirth = petBean.getDateOfBirth();
        // petBean.setDateOfBirth(dateOfBirth);
        petBean.setDateOfBirth(petBean.getDateOfBirth().substring(0, 10));
        System.out.println("======\n\n "+petBean.getOwnerId()+"\n\n===========");
        
        System.out.println("======\n\n "+petBean.getOwnerId()+"\n\n===========");
        
        System.out.println("======\n\n "+petBean.getBreed()+"\n\n===========");
        
        System.out.println("======\n\n "+petBean.getPetName()+"\n\n===========");
        if(saveToDB(petBean) == true) {
            return "success";
        } else {
            return ERROR;
        }
    }

    public boolean saveToDB(Pet petBean) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO pets(owner_id, pet_name,date_of_birth, breed, coat_color) VALUES('"+petBean.getOwnerId()+"','"+petBean.getPetName()+"','"+petBean.getDateOfBirth()+"','"+petBean.getBreed()+"','"+petBean.getCoatColor()+"')";
                statement.executeUpdate(sql);
                successMessage = "Pet Successfully registered!";
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    public Pet getPetBean() {
        return petBean;
    }

    public void setPetBean(Pet pet) {
        RegisterPet.petBean = pet;
    }


    public String getError() {
        return error;
    }


    public void setError(String error) {
        this.error = error;
    }


    public String getSuccessMessage() {
        return successMessage;
    }


    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    
    
}
