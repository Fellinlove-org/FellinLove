package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cliente;

public interface ClienteService {

    public Cliente SearchById(Long id);

    public Cliente findByCedula(String cedula);

    public List<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public Cliente add(Cliente cliente);
}
