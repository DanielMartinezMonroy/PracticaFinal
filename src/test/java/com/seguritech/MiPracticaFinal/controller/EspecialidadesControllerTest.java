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
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
    @Before
    public void inicializar(){
        mockMvc=MockMvcBuilders.standaloneSetup(espCont).build();
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
    @Test
    public void testGetEspecialidad() throws Exception {
        System.out.println("getEspecialidad");
        mockMvc.perform(get("/especialidades/1")
                .accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.descripcion").isString());
    }   
}
