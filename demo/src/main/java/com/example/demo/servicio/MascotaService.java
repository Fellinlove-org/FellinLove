package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.entidad.Mascota;


public interface MascotaService {

    public Mascota SearchById(int id);

    public Collection<Mascota> SearchAll();
    
}