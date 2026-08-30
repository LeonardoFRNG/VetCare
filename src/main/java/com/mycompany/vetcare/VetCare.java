/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vetcare;

import com.mycompany.vetcare.model.Owner;
import com.mycompany.vetcare.repository.OwnerRepository;
import com.mycompany.vetcare.repository.OwnerRepositoryImpl;
import java.time.LocalDate;

/**
 *
 * @author leonardodicaprio
 */
public class VetCare {

 public static void main(String[] args) {
     
     try {
        //1. instanciamos la implementacion, pero la guardamos en una variable de tipo interfaz (Polimorfismo)
        OwnerRepository ownerRepo = new OwnerRepositoryImpl();
        
        // 2. Creamos un objeto Owner en Java
        Owner nuevoPropietario = new Owner(
                "CC",
                "103353342",
                "Isabella Jimenez",
                "3001234332",
                "Isabella@gmail.com",
                "Calle 12, 23 - 43",
                true,
                LocalDate.now()
        );
        ownerRepo.save(nuevoPropietario);
         System.out.println("Proceso de guardado, exitosamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    
    
}
