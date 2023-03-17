/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author eya_o
 */


import java.util.List;

public class Doctor extends User {
    private String degree;
    private List<String> specializations; // a doctor can have multiple specializations.
    private String phoneNumber;

    public Doctor(int id, String firstName, String lastName, String email, String password, String degree, List<String> specializations, String phoneNumber) {
        super(id, firstName, lastName, email, password);
        this.degree = degree;
        this.specializations = specializations;
        this.phoneNumber = phoneNumber;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<String> specializations) {
        this.specializations = specializations;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", degree='" + degree + '\'' +
                ", specializations=" + specializations +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

