package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.Administrador;


public interface AdministradorService {

    public Optional<Administrador> SearchById(Long id);

    public Optional<Administrador> findByCedula(String cedula);

    public Collection<Administrador> SearchAll();

    public void deleteById(Long id);

    public void update(Administrador administrador);

    public void add(Administrador administrador);
}
