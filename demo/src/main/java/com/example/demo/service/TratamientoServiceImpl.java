package com.example.demo.service;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tratamiento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService{

    @Autowired 
     private TratamientoRepository tratamientoRepository;

    @Override
    public Optional<Tratamiento> SearchById(Long id) {
        return tratamientoRepository.findById(id);
    }

    @Override
    public Collection<Tratamiento> SearchAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void delete(Long id) {
        tratamientoRepository.deleteById(id);
    }
    





}
