package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import com.example.demo.model.Mascota;


public interface MascotaService {

    public Mascota SearchById(Long id);

    public Collection<Mascota> SearchAll();

    public void add(Mascota mascota);

    public void add(Mascota mascota, Long clienteId);

    public void update(Mascota mascota);

    public void delete(Long id);

    List<Mascota> findByClienteId(Long clienteId);   
}
