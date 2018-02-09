/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.domain.repositories;

import com.seguritech.MiPracticaFinal.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
