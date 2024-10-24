package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente SearchById(Long id) {
        return clienteRepository.findById(id).orElse(null);
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
    public Cliente add(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Override
    public Cliente findByCedula(String cedula) {
        return clienteRepository.findByCedula(cedula).orElse(null);
    }
    

}
