package com.example.demo.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Mascota;

@Repository
public class MascotaRepository {

    private Map<Integer, Mascota> mascotas = new HashMap<>();

    public MascotaRepository() {
        mascotas.put(1, new Mascota(1, "Hannah", "husky", 3, 28, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        mascotas.put(2, new Mascota(2, "Luna", "poodle", 2, 20, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        mascotas.put(3, new Mascota(3, "Lola", "poodle", 1, 15, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        mascotas.put(4, new Mascota(4, "Lola", "poodle", 1, 15, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        mascotas.put(5, new Mascota(5, "Lola", "poodle", 1, 15, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        mascotas.put(6, new Mascota(6, "Lola", "poodle", 1, 15, "vacío", "https://http2.mlstatic.com/D_Q_NP_2X_969716-MCO49798829031_042022-T.webp"));
        
    }

    public Mascota findById(int id) {
        return mascotas.get(id);
    }

    public Collection<Mascota> findAll() {
        return mascotas.values();
    }



}
