/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Personas;
import com.seguritech.MiPracticaFinal.domain.repositories.PersonasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
public class PersonasController {
    @Autowired
    private PersonasRepository persRepository;
    
    @RequestMapping(value="/personas")
    public List<Personas> listAll(){
        List<Personas>persona=persRepository.findAll();
        System.out.println(persona.size());
        return persona;
    }
}
