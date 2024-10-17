package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RequestMapping("/cliente")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControler {

    @Autowired
    ClienteService clienteService;

    @Autowired
    MascotaService mascotaService;


    //METODO PARA ENCONTRAR A UN CLIENTE POR SI ID
    //url: http://localhost:8090/cliente/find/1
    @GetMapping("/find/{id}")
    public Optional<Cliente> findById(@PathVariable("id") Long id) {
        return clienteService.SearchById(id);
    }


    //METODO PARA ENCONTRAR A TODOS LOS CLIENTES
    //url: http://localhost:8090/cliente/find/all
    @GetMapping("/find/all")
    public List<Cliente> mostrarTodosClientes() {
        return clienteService.SearchAll();
    }


    //METODO PARA AGREGAR A UN CLIENTE
    //url: http://localhost:8090/cliente/add
    @PostMapping("/add")
    public String agregarCliente(@org.springframework.web.bind.annotation.RequestBody Cliente cliente) {
        Optional<Cliente> c = clienteService.SearchById(cliente.getId());
        if (!c.isPresent()) {
            clienteService.add(cliente);
            return "si lo agrego";
        }else{
            return "EL CLIENTRE YA ESTA ";
        }
    }


    //METODO PARA ACTUALIZAR UN CLIENTE
    //url: http://localhost:8090/cliente/update
    @PutMapping("update")
    public String update(@org.springframework.web.bind.annotation.RequestBody Cliente cliente) {
        clienteService.update(cliente);
        return "se actualizo";
    }
    

    //METODO PARA BORRAR UN CLIENTE
    //url: http://localhost:8090/cliente/delete/1
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        List<Mascota> mascotas = mascotaService.findByClienteId(id);
        for (Mascota mascota : mascotas) {
            mascotaService.delete(mascota.getId());
        }
        clienteService.deleteById(id);
        return "se borro";
    }
    

}
