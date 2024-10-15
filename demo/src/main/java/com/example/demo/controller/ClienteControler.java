package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.model.MascotaDTO;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@RequestMapping("/clientes")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControler {

    @Autowired
    ClienteService clienteService;

    @Autowired
    MascotaService mascotaService;
    

    @GetMapping("/search/{cedula}")
    public Optional<Cliente> findByCedula(@PathVariable("cedula") String cedula) {
        return clienteService.findByCedula(cedula);
    }

    @GetMapping("/all")
    public List<Cliente> mostrarTodosClientes() {
        return clienteService.SearchAll();
    }

   

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

    

    @GetMapping("delete/{id}")
    public String BorrarCliente(@PathVariable("id") Long id){
        List<Mascota> mascotas = mascotaService.findByClienteId(id);
        for (Mascota mascota : mascotas) {
            mascotaService.delete(mascota.getId());
        }
        clienteService.deleteById(id);
        return "redirect:/clientes/all";
        
    }

    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id) {
        //clienteService.update(cliente);
        return "redirect:/clientes/all";
    }
    
    
    
}
