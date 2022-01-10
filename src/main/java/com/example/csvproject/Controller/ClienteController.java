/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Controller;

import com.example.csvproject.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.csvproject.Model.Cliente;
import com.example.csvproject.util.ExportCSV;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;



/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteservice;

    //Guardar cliente
    @PostMapping(path = "/savecustomer")
    public ResponseEntity saveCustomer(@RequestBody Cliente cliente) {
        clienteservice.crearCliente(cliente);
        return ResponseEntity.ok("Added customer with CI " + cliente.getCedula());
    }

    //GET
    @GetMapping(path = "/listcustomers")
    public ResponseEntity listCustomers() {
        return ResponseEntity.ok(clienteservice.listarCliente());
    }
    
    @GetMapping(path="/export/downloadCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
        
        
        List<Cliente> listClientes = clienteservice.listarCliente();
        ExportCSV export = new ExportCSV();
        export.exportData(response, listClientes);
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//        
//        String[] csvHeader ={"Cedula","Nombre","Apellido","Correo"};
//        String[] nameMapping={"cedula","nombre","apellido","correo"};
//        
//        for(Cliente cliente : listClientes){
//            csvWriter.write(cliente, nameMapping);
//        }
//        csvWriter.close();


    }

}
