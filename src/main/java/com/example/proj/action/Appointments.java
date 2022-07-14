package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.proj.model.Appointment;
import com.opensymphony.xwork2.ActionSupport;

public class Appointments extends ActionSupport{
    ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    Appointment appointment;


    public String execute() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/petclinic?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT * FROM appointments ORDER BY appointment_id ASC";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Appointment appointment=new Appointment();
                    appointment.setAppointmentId(rs.getInt(1));
                    appointment.setClientId(rs.getInt(2));
                    appointment.setPetId(rs.getInt(3));
                    appointment.setVeterinarianId(rs.getInt(4));
                    appointment.setService(rs.getInt(5));
                    appointment.setSchedule(rs.getString(6));
                    appointments.add(appointment);
                        sql = "SELECT * FROM accounts where account_id = '"+appointment.getClientId()+"'";
                        preparedStatement = connection.prepareStatement(sql);
                        ResultSet client = preparedStatement.executeQuery();
                        while(client.next()){
                            appointment.setClient(client.getString("first_name"+"last_name"));
                        } client.close(); 
                    System.out.println("\n\n\n\n\n=================" + appointment.getClient()+"====================\n\n\n\n\n");

                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }


    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }


    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }



    public Appointment getAppointment() {
        return appointment;
    }


    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    
    
}
