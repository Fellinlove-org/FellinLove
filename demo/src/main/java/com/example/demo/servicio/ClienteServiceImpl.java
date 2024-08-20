package com.example.demo.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Cliente;
import com.example.demo.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente SearchById(int id) {

        return clienteRepository.findById(id);

    }
    @Override
    public Collection<Cliente> SearchAll() {

        return clienteRepository.findAll();
        
    }
    @Override
    public void deleteById(int id) {
        clienteRepository.deleteById(id);
        
    }
    @Override
    public void update(Cliente cliente) {
        clienteRepository.update(cliente);
        
    }
    @Override
    public void add(Cliente cliente) {
        clienteRepository.add(cliente);
    }
    

}
