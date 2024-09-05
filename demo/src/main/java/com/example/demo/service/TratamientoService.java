package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.Tratamiento;

public interface TratamientoService {
    public Optional <Tratamiento> SearchById(Long id);

    public Collection <Tratamiento> SearchAll();

    public void add(Tratamiento tratamiento);

    public void update(Tratamiento tratamiento);

    public void delete(Long id);


}



