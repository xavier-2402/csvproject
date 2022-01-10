/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Service;

import com.example.csvproject.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.csvproject.Model.Cliente;
import java.util.List;

/**
 *
 * @author usuario
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienterepository;
    
    public Cliente crearCliente(Cliente cliente){
        return  clienterepository.save(cliente);
    }
    
    public List<Cliente> listarCliente(){
        return clienterepository.findAll();
    }
    
    
}
