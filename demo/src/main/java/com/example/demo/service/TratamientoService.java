package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Tratamiento;

@Service
public interface TratamientoService {

    public Tratamiento findById(Long id);

    public Collection<Tratamiento> findAll();

    public void add(Tratamiento consulta);

    public void deleteById(Long id);

    public void update(Tratamiento consulta);
}


