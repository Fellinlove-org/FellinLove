package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Mascota SearchById(Long id) {
        
        return mascotaRepository.findById(id).get();
    }

    @Override
    public List<Mascota> SearchAll() {

        return mascotaRepository.findAll();
    }

    @Override
    public Mascota add(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota update(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void delete(Long id) {
        
        mascotaRepository.deleteById(id);
    }

    @Override
    public List<Mascota> findByClienteId(Long clienteId) {
        return mascotaRepository.findByClienteId(clienteId);
    }


    @Override
    public Integer countActive() {
        return mascotaRepository.countActive();
    }
    
}
