package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrador;
import com.example.demo.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    
    @Autowired AdministradorRepository administradorRepository;

    @Override
    public Optional<Administrador> SearchById(Long id){
        return administradorRepository.findById(id);
    }

    @Override
    public Optional<Administrador> findByCedula(String cedula){
        return administradorRepository.findByCedula(cedula);
    }

    @Override
    public Collection<Administrador> SearchAll(){
        return administradorRepository.findAll();
    }

    @Override
    public void deleteById(Long id){
        administradorRepository.deleteById(id);
    }

    @Override
    public void update(Administrador administrador){
        administradorRepository.save(administrador);
    }

    @Override
    public void add(Administrador administrador){
        administradorRepository.save(administrador);
    }
}
