package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.Droga;

public interface DrogaService {
    public Optional <Droga> SearchById(Long id);

    public Collection <Droga> SearchAll();

    public void add(Droga droga);

    public void update(Droga droga);

    public void delete(Long id);


}