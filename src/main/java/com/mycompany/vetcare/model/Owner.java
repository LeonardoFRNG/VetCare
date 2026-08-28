/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcare.model;

import java.time.LocalDate;
/**
 *
 * @author Coder
 */
public class Owner {
    private Integer id; //usamos Integer en ves de int para permitir nulls si el objeto aun no esta en la bd.
    private String documentType;
    private String documentNumber;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private boolean isActive;
    private LocalDate registrationDate;

    public Owner() {
    }

    public Owner(String documentType, String documentNumber, String fullName, String phone, String email, String address, boolean isActive, Localdate registrationDate) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
    }

    public Owner(Integer id, String documentType, String documentNumber, String fullName, String phone, String email, String address, boolean isActive, Localdate registrationDate) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
  @Override
    public String toString() {
        return fullName + "(Doc: " + documentNumber + ")"; //util para mostra en listados de JOptionPane
    }
}
