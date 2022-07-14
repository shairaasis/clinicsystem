package com.example.proj.model;

public class Appointment {
    public static Appointment appointmentBean;
    private int appointmentId;
    private String client;
    private int clientId;
    private int petId;
    private int veterinarianId;
    private int service;
    private String schedule;

    public Appointment() {}

    public Appointment(int appointmentId, int clientId,int petId, int veterinarianId, int service, String schedule, String client){
        this.appointmentId = appointmentId;
        this.clientId = clientId;
        this.petId = petId;
        this.veterinarianId = veterinarianId;
        this.service = service;
        this.schedule = schedule;
        this.client = client;
    }

    public static Appointment getAppointmentBean() {
        return appointmentBean;
    }

    public static void setAppointmentBean(Appointment appointmentBean) {
        Appointment.appointmentBean = appointmentBean;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(int veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    
    
}
