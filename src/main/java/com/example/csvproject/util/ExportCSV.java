/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.util;

import com.example.csvproject.Model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

/**
 *
 * @author usuario
 */
public class ExportCSV {
     
   public void exportData(HttpServletResponse response,List<Cliente> listClientes) throws IOException{
      
       
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        
        String[] csvHeader ={"Cedula","Nombre","Apellido","Correo"};
        String[] nameMapping={"cedula","nombre","apellido","correo"};
        
        for(Cliente cliente : listClientes){
           csvWriter.write(cliente, nameMapping);
        }
        csvWriter.close();  
    }
}
