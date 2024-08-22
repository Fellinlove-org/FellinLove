package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Cliente;

public interface ClienteService {

    public Cliente SearchById(Long id);

    public Collection<Cliente> SearchAll();

    public void deleteById(Long id);

    public void update(Cliente cliente);

    public void add(Cliente cliente);
}
