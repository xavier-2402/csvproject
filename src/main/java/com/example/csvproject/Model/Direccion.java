/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.csvproject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author usuario
 */
@Entity
@Table(name="direccion")
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_direccion;
    private String pais;
    private String ciudad;
    private String calleprincipal;
}
