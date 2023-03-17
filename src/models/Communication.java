/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author eya_o
 */

import java.time.LocalDateTime;

public class Communication {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String message;
    private LocalDateTime dateTime;
    private boolean isFromPatient;

    public Communication(int id, Patient patient, Doctor doctor, String message, LocalDateTime dateTime, boolean isFromPatient) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.message = message;
        this.dateTime = dateTime;
        this.isFromPatient = isFromPatient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isFromPatient() {
        return isFromPatient;
    }

    public void setFromPatient(boolean fromPatient) {
        isFromPatient = fromPatient;
    }

    @Override
    public String toString() {
        return "Communication{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                ", isFromPatient=" + isFromPatient +
                '}';
    }
}
