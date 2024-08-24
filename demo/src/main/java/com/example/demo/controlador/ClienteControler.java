package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Cliente;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;





@RequestMapping("/clientes")
@Controller
public class ClienteControler {

    @Autowired
    ClienteService ClienteService;

    @Autowired
    MascotaRepository mascotaRepository;
    
    @GetMapping("/all")
    public String mostrarTodosClientes(Model model) {
        model.addAttribute("clientes", ClienteService.SearchAll());
        return "mostrar_todos_clientes";
    }

    @GetMapping("/find/{id}")
    public String mostrarCliente(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cliente", ClienteService.SearchById(id));
        model.addAttribute("mascotas", mascotaRepository.findByClienteId(id));
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
        ClienteService.add(cliente);
        return "redirect:/clientes/all";
    }

    @GetMapping("delete/{id}")
    public String BorrarCliente(@PathVariable("id") Long id){
        ClienteService.deleteById(id);
        return "redirect:/clientes/all";
        
    }

    @GetMapping("update/{id}")
    public String mostarFormularioUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", ClienteService.SearchById(id));
        return "modificar_cliente";
    }
    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        ClienteService.update(cliente);
        return "redirect:/clientes/all";
    }
    
    
    
}
