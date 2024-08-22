package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public Mascota SearchById(Long id) {
        
        return mascotaRepository.findById(id).get();
    }

    @Override
    public Collection<Mascota> SearchAll() {

        return mascotaRepository.findAll();
    }

    @Override
    public void add(Mascota mascota) {
    
        mascotaRepository.save(mascota);
    }

    @Override
    public void update(Mascota mascota) {
        
        mascotaRepository.save(mascota);
    }

    @Override
    public void delete(Long id) {
        
        mascotaRepository.deleteById(id);
    }
    
}
