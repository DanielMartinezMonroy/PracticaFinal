/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Administrador;
import com.seguritech.MiPracticaFinal.domain.repositories.AdministradorRepository;
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
public class AdministradorController {
    @Autowired
    private AdministradorRepository admRepository;
    
    //Consulta de datos
    @RequestMapping(value = "/administrador")
    public List<Administrador> listAll(){
        List<Administrador>administrador=admRepository.findAll();
        System.out.println(administrador.size());
        return administrador;
    }
    //Insertar datos
    @PostMapping("/administrador")
    public ResponseEntity<Administrador> create(@RequestBody Administrador administrador) throws URISyntaxException{
        if(administrador.getId()!=null){
            return ResponseEntity.badRequest().header("Error", "El id debe ser nulo").body(null);
        }
        admRepository.save(administrador);
        return ResponseEntity.created(new URI("/administrador/"+administrador.getId())).body(administrador);
    }
    //Actualizar datos
    @PutMapping("/administrador")
    public ResponseEntity<Administrador> update(@RequestBody Administrador administrador) throws URISyntaxException{
        if(administrador.getId()==null){
            return ResponseEntity.badRequest().header("Error", "El id NO debe ser nulo").body(null);
        }
        admRepository.save(administrador);
        return ResponseEntity.ok().body(administrador);
    }   
    //Borrado de Datos
    @DeleteMapping("/administrador/{id}")
    public ResponseEntity <Administrador> delete(@PathVariable("id")Long id){
        admRepository.delete(id);
        return ResponseEntity.ok().build();
    }
    //Busqueda por id
    @GetMapping("/administrador/{id}")
    public ResponseEntity<Administrador> getAdministrador(@PathVariable("id")Long id){
        Administrador administrador=admRepository.findOne(id);
        if(administrador==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(administrador);
    }
}
