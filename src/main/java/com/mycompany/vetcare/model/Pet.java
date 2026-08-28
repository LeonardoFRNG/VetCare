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
public class Pet{
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private String sex;
    private LocalDate birthDate;
    private double weight;
    
    private Owner owner;
    
    private boolean isActive;
    private LocalDate registrationDate;

    public Pet() {
    }

    public Pet(String name, String species, String breed, String sex, LocalDate birthDate, double weight, Owner owner, boolean isActive, LocalDate registrationDate) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.birthDate = birthDate;
        this.weight = weight;
        this.owner = owner;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
    }

    public Pet(Integer id, String name, String species, String breed, String sex, LocalDate birthDate, double weight, Owner owner, boolean isActive, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.birthDate = birthDate;
        this.weight = weight;
        this.owner = owner;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
    }

    

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Owner getOwnerId() {
        return owner;
    }

    public void setOwnerId(Integer ownerId) {
         this.owner = owner;
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
        return name + " (" + species + " - " + breed + ")";
    } 

    
    
    
}
