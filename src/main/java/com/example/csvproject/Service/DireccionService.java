/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Service;

import com.example.csvproject.Repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.csvproject.Model.Direccion;
import java.util.List;

/**
 *
 * @author usuario
 */
@Service
public class DireccionService {
    
    @Autowired
    DireccionRepository direccionrepository;
    
    public Direccion guardarDireccion(Direccion direccion){
        return direccionrepository.save(direccion);
    }
    
    public List<Direccion> listardirecciones(){
        return direccionrepository.findAll();
    }
    
}
