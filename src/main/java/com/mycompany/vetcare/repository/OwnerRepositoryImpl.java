/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcare.repository;

import com.mycompany.vetcare.config.DatabaseConnection;
import com.mycompany.vetcare.model.Owner;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author leonardodicaprio
 */
public class OwnerRepositoryImpl implements OwnerRepository {
    
    @Override
    public void save(Owner owner) {
        //la consulta SQL con '?' para evitar inyeccion SQL (PreparedStatement)
      String sql = "INSERT INTO Owners (document_type, document_number, full_name, phone, email, address, is_active, registration_date) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    //Try-with-resources: abre la conexion y el preparedstatement y los cierra automaticamente al terminar
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            
        //reemplazamos los '?' con los datos del objeto de java.
        stmt.setString(1, owner.getDocumentType());
        stmt.setString(2, owner.getDocumentNumber());
        stmt.setString(3, owner.getFullName());
        stmt.setString(4, owner.getPhone());
        stmt.setString(5, owner.getEmail());
        stmt.setString(6, owner.getAddress());
        stmt.setBoolean(7, owner.isActive());
        //Convertimos LocalDate de java a Date de sql
        stmt.setDate(8, Date.valueOf(owner.getRegistrationDate()));
        
        //despues ejecutamos la consulta en la base de datos
        int rowsAffected = stmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Propietario guardado exitosamente en la Base de Datos.");
        }
        
    } catch (SQLException e){
        System.err.println("Error al guardar al propietario: " + e.getMessage());
        //Mas adelante se lanzara una exception personalizada aca
    }
}

    // --- MÉTODOS VACÍOS POR AHORA (Requeridos por la interfaz) ---
    @Override
    public Optional<Owner> findById(Integer id) { return Optional.empty(); }
    @Override
    public List<Owner> findAll() { return null; }
    @Override
    public void update(Owner owner) {}
    @Override
    public void changeStatus(Integer id, boolean isActive) {}
    @Override
    public Optional<Owner> findByDocument(String documentNumber) { return Optional.empty(); }
}
