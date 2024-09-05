package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.Cliente;

public interface ClienteService {

    public Optional<Cliente> SearchById(Long id);

    public Optional<Cliente> findByCedula(String cedula);

    public Collection<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
}
