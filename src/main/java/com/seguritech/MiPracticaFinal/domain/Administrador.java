/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Usuario
 */
@Entity
@DiscriminatorValue(value = "ADMINISTRADOR")
public class Administrador extends Personas{
    
}
