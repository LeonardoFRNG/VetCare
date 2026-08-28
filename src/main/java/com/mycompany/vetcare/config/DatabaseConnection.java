/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vetcare.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Coder
 */
public class DatabaseConnection {
    //Primero definimos las constantes de conexion las cuales son la URL, USER, PASSWORD.
    //"jdbc:mysql://" es el protocolo
    //"localhost:3306 es nuestro servidor local y el puerto por defecto de MySQL"
    //"vetcare" es el nombre exacto de la base de datos que se creo.
    private static final String URL = "jdbc:mysql://localhost:3306/vetcare";
    
    private static final String USER = "root";
    private static final String PASSWORD = "Qwe.123*";
    
    //constructor privado para evitar que alguien haga: new DatabaseConnection()
    //no necesitamos instanciar esta clase si no usar su metodo estatico.
    private DatabaseConnection() {
    }
    
    //Metodo estatico que agrega la conexion
    public static Connection getConnection() throws SQLException {
        //DriverManager lee la URL, busca el driver en el pom.xml y abre el tunel.
        return DriverManager.getConnection(URL, USER, PASSWORD );
    }
    
   
    
    
}
