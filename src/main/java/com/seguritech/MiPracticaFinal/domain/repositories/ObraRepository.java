/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.domain.repositories;

import com.seguritech.MiPracticaFinal.domain.ObrasSociales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniel
 */
public interface ObraRepository extends JpaRepository<ObrasSociales, Long>{
    
}
