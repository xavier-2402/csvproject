/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Controller;

import com.example.csvproject.Model.Direccion;
import com.example.csvproject.Service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class DireccionController {
    
    @Autowired
    DireccionService direccionservice;
    
    //POST
    @PostMapping(path = "/saveaddress")
    public ResponseEntity saveAddress(@RequestBody Direccion direccion) {
        direccionservice.guardarDireccion(direccion);
        return ResponseEntity.ok("Added addresss ");
    }

    //GET
    @GetMapping(path = "/listcustomers")
    public ResponseEntity listAddress() {
        return ResponseEntity.ok(direccionservice.listardirecciones());
    }
}
