package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
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
    public Mascota add(Mascota mascota, Long idcliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idcliente);
        if(cliente.isPresent()){
            mascota.setCliente(cliente.get());
            return mascotaRepository.save(mascota);
        }else {
            return null;
        }
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
