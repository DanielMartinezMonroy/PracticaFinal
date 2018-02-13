/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.modulos;

import com.seguritech.MiPracticaFinal.domain.Medico;
import com.seguritech.MiPracticaFinal.domain.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel
 */
@RestController
public class ModuloAdministrador {
    //Gestion de medicos: Bajas (lógicas)
    @Autowired
    protected EntityManager entityManager;
    
    public EntityManager getEntityManager(){
        return entityManager;
    }
    //Consulta de datos (Estaran dados de Baja Logica si es igual a 0)
    //Este metodo solo mostrara los datos donde NO esten dados de baja Logica
    @RequestMapping(value = "/medicobajalogica")
    public List<Medico> getSinBajaLogica(){
        Query query=getEntityManager().createQuery("select a from Medico a where a.bajaLogica=1");
        return query.getResultList();
    }
    //Listar los pacientes por obra social
    @RequestMapping(value = "/paciente/obrasocial/{id}")
    public List<Paciente> getPacienteObraSocial1(@PathVariable("id")Long id){
        Query query=getEntityManager().createQuery("select a from Paciente a where a.idObraSocial="+id);
        return query.getResultList();
    }
}
