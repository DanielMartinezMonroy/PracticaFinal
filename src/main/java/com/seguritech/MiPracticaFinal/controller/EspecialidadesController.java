/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Especialidades;
import com.seguritech.MiPracticaFinal.domain.repositories.EspecialidadesRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
public class EspecialidadesController {
    @Autowired
    private EspecialidadesRepository espRepository;
    
    @RequestMapping(value = "/especialidades")
    public List<Especialidades> listAll(){
        List<Especialidades>especialidad=espRepository.findAll();
        System.out.println(especialidad.size());
        return especialidad;
    }
    @GetMapping("/especialidades/{id}")
    public ResponseEntity<Especialidades> getEspecialidad(@PathVariable("id")Long id){
        Especialidades especialidad=espRepository.findOne(id);
        if(especialidad==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(especialidad);
    }
    //Insertar datos
    @PostMapping("/especialidades")
    public ResponseEntity<Especialidades> create(@RequestBody Especialidades especialidad) throws URISyntaxException{
        if(especialidad.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        espRepository.save(especialidad);
        return ResponseEntity.created(new URI("/roles/"+especialidad.getId())).body(especialidad);
    }
    
    //Actualizar datos
    @PutMapping("/roles")
    public ResponseEntity<Especialidades> update(@RequestBody Especialidades especialidad) throws URISyntaxException{
        if(especialidad.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        espRepository.save(especialidad);
        return ResponseEntity.ok().body(especialidad);
    }   
}
