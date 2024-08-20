package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entidad.Cliente;
import com.example.demo.servicio.ClienteService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("/clientes")
@Controller
public class ClienteControler {

    @Autowired
    ClienteService ClienteService;
    
    @GetMapping("/all")
    public String mostrarTodosClientes(Model model) {
        model.addAttribute("clientes", ClienteService.SearchAll());
        return "mostrar_todos_clientes";
    }

    @GetMapping("/find/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") int id) {
        model.addAttribute("cliente", ClienteService.SearchById(id));
        return "mostrar_cliente";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Cliente cliente= new Cliente(0, 0, "", "", "", "");

        model.addAttribute("cliente", cliente);

        return "crear_cliente";
    }
    @PostMapping("/agregar")
    public String agregarCliente(Model model, Cliente cliente) {
        ClienteService.add(cliente);
        return "redirect:/clientes/all";
    }
    
    
}