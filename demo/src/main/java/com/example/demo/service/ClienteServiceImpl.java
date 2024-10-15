package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> SearchById(Long id) {
        return clienteRepository.findById(id);

    }
    @Override
    public List<Cliente> SearchAll() {

        return clienteRepository.findAll();
        
    }
    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
        
    }
    @Override
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
        
    }
    @Override
    public void add(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    @Override
    public Optional<Cliente> findByCedula(String cedula) {
        return clienteRepository.findByCedula(cedula);
    }
    

}
