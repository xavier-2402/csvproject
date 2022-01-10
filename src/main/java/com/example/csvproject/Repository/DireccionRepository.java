/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.csvproject.Model.Direccion;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    
}
