package com.example.demo.service;

import java.util.Collection;

import java.util.List;
import com.example.demo.model.Droga;

public interface DrogaService {
    public Droga SearchById(Long id);

    public List <Droga> SearchAll();

    public void add(Droga droga);

    public void update(Droga droga);

    public void delete(Long id);

    public Double getVentasTotales();

    public Double getGananciasTotales();

    public List<Object[]> getTopTratamientos();
}