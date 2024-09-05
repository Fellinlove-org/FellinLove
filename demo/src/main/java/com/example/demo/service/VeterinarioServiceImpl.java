package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Veterinario;
import com.example.demo.repository.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    VeterinarioRepository veterinarioRepository;

    @Override
    public Collection<Veterinario> SearchAll() {

        return veterinarioRepository.findAll();
    }

    @Override
    public Optional<Veterinario> SearchById(Long id) {
        return veterinarioRepository.findById(id);
    }

    @Override
    public Optional<Veterinario> findByCedula(String cedula) {

        return veterinarioRepository.findByCedula(cedula);
    }

    @Override
    public void deleteById(Long id) {

        veterinarioRepository.deleteById(id);
    }

    @Override
    public void update(Veterinario veterinario) {

        veterinarioRepository.save(veterinario);
    }

    @Override
    public void add(Veterinario veterinario) {

        veterinarioRepository.save(veterinario);
    }
    
}
