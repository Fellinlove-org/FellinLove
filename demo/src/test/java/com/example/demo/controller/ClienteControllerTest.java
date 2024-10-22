package com.example.demo.controller;

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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.jboss.jandex.Result;

@WebMvcTest(controllers = ClienteControler.class)
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
            Optional.empty()
        );
        when(clienteService.add(Mockito.any(Cliente.class))).thenReturn(cliente);


        ResultActions result = mockMvc.perform(
           post("/cliente/add")
           .contentType("application/json")
           .content(mapper.writeValueAsString(cliente))
        );

        result.andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.cedula").value(cliente.getcedula()))
        .andExpect(jsonPath("$.nombre").value(cliente.getNombre()))
        .andExpect(jsonPath("$.correo").value(cliente.getCorreo()))
        .andExpect(jsonPath("$.celular").value(cliente.getCelular()))
        .andExpect(jsonPath("$.foto").value(cliente.getFoto()));
    }
    
}
