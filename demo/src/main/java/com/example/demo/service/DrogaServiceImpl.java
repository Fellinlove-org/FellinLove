package com.example.demo.service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Droga;
import com.example.demo.repository.DrogaRepository;

@Service
public class DrogaServiceImpl implements DrogaService{

    @Autowired 
     private DrogaRepository drogaRepository;

    @Override
    public Droga SearchById(Long id) {
        return drogaRepository.findById(id).get();
    }

    @Override
    public List<Droga> SearchAll() {
        return drogaRepository.findAll();
    }

    @Override
    public void add(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public void update(Droga droga) {
        drogaRepository.save(droga);
    }

    @Override
    public void delete(Long id) {
        drogaRepository.deleteById(id);
    }

    @Override
    public Double getVentasTotales() {
        return drogaRepository.getVentasTotales();
    }

    @Override
    public Double getGananciasTotales() {
        return drogaRepository.getGananciasTotales();
    }

    @Override
    public List<Object[]> getTopTratamientos() {
        return drogaRepository.findTopByUnidadesVendidas();
    }
    





}
