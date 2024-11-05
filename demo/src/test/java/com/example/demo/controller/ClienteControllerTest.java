package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;


@WebMvcTest(controllers = ClienteController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void ClienteController_agregarCliente_cliente() throws Exception {
        Cliente cliente = new Cliente(0L, "123455", "daniel", "teragod@gmail.com", "1234567890", "url fotos");

        when(clienteService.SearchById(Mockito.anyLong())).thenReturn(
            null
        );
        when(clienteService.add(Mockito.any(Cliente.class))).thenReturn(cliente);


        ResultActions result = mockMvc.perform(
           post("/cliente/add")
           .contentType("application/json")
           .content(mapper.writeValueAsString(cliente))
        );

        result.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.cedula").value(cliente.getCedula()))
        .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
        .andExpect(jsonPath("$.correo").value(cliente.getCorreo()))
        .andExpect(jsonPath("$.celular").value(cliente.getCelular()))
        .andExpect(jsonPath("$.foto").value(cliente.getFoto()));
    }


    @Test
    public void ClienteController_findAll_NotEmptyList() throws Exception {

        when(clienteService.SearchAll()).thenReturn(
            List.of(
                new Cliente(1L, "123455", "daniel", "teragod@gmail.com", "1234567890", "url fotos"),
                new Cliente(2L, "123455", "daniel", "teragod@gmail.com", "1234567890", "url fotos"),
                new Cliente(3L, "123455", "daniel", "teragod@gmail.com", "1234567890", "url fotos"),
                new Cliente(4L, "123455", "daniel", "teragod@gmail.com", "1234567890", "url fotos")
            )  
        );

        ResultActions result = mockMvc.perform(
            get("/cliente/find/all")
        );

        result.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.size()").value(4))
        .andExpect(jsonPath("$[0].cedula").value("123455"))
        .andExpect(jsonPath("$[0].nombre").value("daniel"))
        .andExpect(jsonPath("$[0].correo").value("teragod@gmail.com"))
        .andExpect(jsonPath("$[0].celular").value("1234567890"))
        .andExpect(jsonPath("$[0].foto").value("url fotos"));

    }


    @Test
    public void ClienteController_findById_Cliente() throws Exception {
        when(clienteService.SearchById(Mockito.anyLong())).thenReturn(
            new Cliente(
                1L,
                "123455", 
                "daniel", 
                "teragod@gmail.com", 
                "1234567890", 
                "url fotos"
            )
        );

        ResultActions result = mockMvc.perform(
            get("/cliente/find/1")
        );

        result.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.cedula").value("123455"))
        .andExpect(jsonPath("$.nombre").value("daniel"))
        .andExpect(jsonPath("$.correo").value("teragod@gmail.com"))
        .andExpect(jsonPath("$.celular").value("1234567890"))
        .andExpect(jsonPath("$.foto").value("url fotos"));
    }

    @Test
    public void ClienteController_findById_NotFound() throws Exception {
        when(clienteService.SearchById(Mockito.anyLong())).thenReturn(
            null
        );

        ResultActions result = mockMvc.perform(
            get("/cliente/find/1")
        );

        result.andExpect(status().isNotFound());
    }
    

    @Test
    public void ClienteController_findByCedula_Cliente() throws Exception {
        when(clienteService.findByCedula(anyString())).thenReturn(
            new Cliente(
                1L,
                "123455", 
                "daniel", 
                "teragod@gmail.com", 
                "1234567890", 
                "url fotos"
            )
        );

        ResultActions result = mockMvc.perform(
            get("/cliente/find/cedula/001")
        );

        result.andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.cedula").value("123455"))
        .andExpect(jsonPath("$.nombre").value("daniel"))
        .andExpect(jsonPath("$.correo").value("teragod@gmail.com"))
        .andExpect(jsonPath("$.celular").value("1234567890"))
        .andExpect(jsonPath("$.foto").value("url fotos"));
    }

    @Test
    public void ClienteController_findByCedula_NotFound() throws Exception {
        when(clienteService.findByCedula(anyString())).thenReturn(
            null
        );

        ResultActions result = mockMvc.perform(
            get("/cliente/find/cedula/1")
        );

        result.andExpect(status().isNotFound());
    }
}
