/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.domain.repositories;

import com.seguritech.MiPracticaFinal.domain.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniel
 */
public interface TurnosRepository extends JpaRepository<Turnos, Long>{
    
}
