/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Especialidades;
import com.seguritech.MiPracticaFinal.domain.ObrasSociales;
import com.seguritech.MiPracticaFinal.domain.repositories.ObraRepository;
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
 * @author Daniel
 */
@RestController
public class ObrasController {
    @Autowired
    private ObraRepository obraRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/obrasocial")
    public List<ObrasSociales> listAll(){
        List<ObrasSociales>obsocial=obraRepository.findAll();
        System.out.println(obsocial.size());
        return obsocial;
    }
    //Insertar datos
    @PostMapping("/obrasocial")
    public ResponseEntity<ObrasSociales> create(@RequestBody ObrasSociales obsocial) throws URISyntaxException{
        if(obsocial.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        obraRepository.save(obsocial);
        return ResponseEntity.created(new URI("/obrasocial/"+obsocial.getId())).body(obsocial);
    }
    //Actualizar datos
    @PutMapping("/obrasocial")
    public ResponseEntity<ObrasSociales> update(@RequestBody ObrasSociales obSocial) throws URISyntaxException{
        if(obSocial.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        obraRepository.save(obSocial);
        return ResponseEntity.ok().body(obSocial);
    }   
    //Borrado de Datos
    @DeleteMapping("/obrasocial/{id}")
    public ResponseEntity <ObrasSociales> delete(@PathVariable("id")Long id){
        obraRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/obrasocial/{id}")
    public ResponseEntity<ObrasSociales> getObrasSociales(@PathVariable("id")Long id){
        ObrasSociales obSocial=obraRepository.findOne(id);
        if(obSocial==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obSocial);
    }
}
