package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tratamiento;
import com.example.demo.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public Tratamiento findById(Long id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void add(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public void update(Tratamiento tratamiento) {
        if (tratamiento.getId() != null && tratamientoRepository.existsById(tratamiento.getId())) {
            tratamientoRepository.save(tratamiento);
        }
    }

    @Override
    public List<Tratamiento> findByMascotaId(Long mascotaId) {
        return tratamientoRepository.findByMascotaId(mascotaId);
    }
}