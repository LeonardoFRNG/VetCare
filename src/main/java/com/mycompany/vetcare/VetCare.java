/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vetcare;

import com.mycompany.vetcare.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author leonardodicaprio
 */
public class VetCare {

 public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("¡Conexión exitosa a MySQL, Leonardo!");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
