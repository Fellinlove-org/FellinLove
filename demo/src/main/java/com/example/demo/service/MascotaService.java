package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Mascota;


public interface MascotaService {

    public Mascota SearchById(Long id);

    public List<Mascota> SearchAll();

    public Mascota add(Mascota mascota, Long idcliente);

    public Mascota update(Mascota mascota);

    public void delete(Long id);

    public List<Mascota> findByClienteId(Long clienteId);

    public Integer countActive();
}
