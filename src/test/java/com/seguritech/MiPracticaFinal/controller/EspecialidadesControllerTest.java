/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Especialidades;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 * @author Daniel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EspecialidadesControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    private EspecialidadesController espCont;
    
    public EspecialidadesControllerTest() {
    }
    /**
     * Test of listAll method, of class EspecialidadesController.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        List<Especialidades> listAll=espCont.listAll();
        assertEquals(listAll.size(), 4);
    }

    /**
     * Test of create method, of class EspecialidadesController.
     */
    
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        Especialidades especialidad = null;
//        EspecialidadesController instance = new EspecialidadesController();
//        ResponseEntity<Especialidades> expResult = null;
//        ResponseEntity<Especialidades> result = instance.create(especialidad);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class EspecialidadesController.
//     */
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        Especialidades especialidad = null;
//        EspecialidadesController instance = new EspecialidadesController();
//        ResponseEntity<Especialidades> expResult = null;
//        ResponseEntity<Especialidades> result = instance.update(especialidad);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class EspecialidadesController.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        Long id = null;
//        EspecialidadesController instance = new EspecialidadesController();
//        ResponseEntity<Especialidades> expResult = null;
//        ResponseEntity<Especialidades> result = instance.delete(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEspecialidad method, of class EspecialidadesController.
//     */
//    @Test
//    public void testGetEspecialidad() {
//        System.out.println("getEspecialidad");
//        Long id = null;
//        mockMvc.perform(get("/especialidades/{id}")).
//                andExpect()
//    }   
}
