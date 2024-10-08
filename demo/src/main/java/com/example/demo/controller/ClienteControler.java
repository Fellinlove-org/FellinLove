package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;
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
    public String mostrarTodosClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "mostrar_todos_clientes";
    }

    @GetMapping("/find/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", clienteService.SearchById(id).get());
        model.addAttribute("mascotas", mascotaService.findByClienteId(id));
        return "mostrar_cliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Cliente cliente= new Cliente("", "", "", "", "");

        model.addAttribute("cliente", cliente);

        return "crear_cliente";
    }

    @PostMapping("/agregar")
    public String agregarCliente(@ModelAttribute("cliente") Cliente cliente) {
        Optional<Cliente> c = clienteService.findByCedula(cliente.getcedula());
        if (!c.isPresent()) {
            clienteService.add(cliente);
            return "redirect:/clientes/all";
        }else{
            return "redirect:/errorUpdate/" + cliente.getcedula();
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

    @GetMapping("update/{id}")
    public String mostarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        Cliente c = clienteService.SearchById(id).get();
        if(c != null){
            model.addAttribute("cliente", c);
            return "modificar_cliente";
        }else{
            return "redirect:/error/" + id;
        }
    }
    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/clientes/all";
    }
    
    
    
}
