package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Veterinario;

public interface VeterinarioService {

    public List<Veterinario> SearchAll();

    public Optional<Veterinario> SearchById(Long id);

    public Optional<Veterinario> findByCedula(String cedula);

    public void deleteById(Long id);

    public void update(Veterinario veterinario);

    public void add(Veterinario veterinario);
}
