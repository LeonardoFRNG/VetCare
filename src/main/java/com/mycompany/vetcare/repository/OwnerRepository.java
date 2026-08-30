/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.vetcare.repository;
import com.mycompany.vetcare.model.Owner;
import java.util.Optional;
import java.util.List;
/**
 *
 * @author leonardodicaprio
 */
public interface OwnerRepository {
    //Crud basico
    void save(Owner owner);
    Optional<Owner> findById(Integer id); //Usamos Optional para evitar NullPointerException si no existe
    List<Owner> findAll();
    void update(Owner owner);
    void changeStatus(Integer id, boolean isActive); //Para el borrado logico activar/descativar
    
    //Busquedas especificas por el documento
    Optional<Owner> findByDocument(String documentNumber);
}
