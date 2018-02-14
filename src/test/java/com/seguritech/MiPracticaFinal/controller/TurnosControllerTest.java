/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguritech.MiPracticaFinal.controller;

import com.seguritech.MiPracticaFinal.domain.Turnos;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Daniel
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnosControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    private TurnosController turnCont;
    
    public TurnosControllerTest() {
    }

    @Before
    public void inicializar(){
        mockMvc=MockMvcBuilders.standaloneSetup(turnCont).build();
    }

    @Test
    public void testListAll() {
        System.out.println("listAll");
        List<Turnos> listAll=turnCont.listAll();
        assertEquals(listAll.size(), 1);
    }
    @Test
    public void testGetTurnos() throws Exception {
        System.out.println("getTurno");
        mockMvc.perform(get("/turno/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.estado").isString());
    }
}
