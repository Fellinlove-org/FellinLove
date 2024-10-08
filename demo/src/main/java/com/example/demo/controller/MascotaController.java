package com.example.demo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.model.MascotaDTO;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RequestMapping("/mascotas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/all")
    public String mostrarTodasMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota";
    }

    @GetMapping("/search/{id}")
    public List<Mascota> buscarMascota(@PathVariable("id") Long id) {
        return mascotaService.findByClienteId(id);
    }

    @PostMapping("/add")
    public void mostrarFormularioCrearMascota(@RequestBody Mascota mascota){
        if (mascota.getNombre() == null) {
            System.out.println("No se puede agregar una mascota sin nombre");
        }
        //mascotaService.add(mascota);
        //if (cliente.isPresent()) {
            // Asiganar cliente
            //Cliente c = cliente.get();
            //mascota.setCliente(c);
            //mascotaService.add(mascota);
            
        //}
    }
        
            
        
    
    @PostMapping("/prueba")
    public Mascota mostrarPrueba(@RequestBody Mascota mascota) {
        try {
            // Ya no es necesario usar ObjectMapper, ya que @RequestBody hace la conversión
            System.out.println("PRUEBA: " + mascota);

            // Devolver la mascota deserializada
            return mascota;
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // En caso de error, devolver null o manejar el error como se requiera
        }
    }


    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        model.addAttribute("cedula", mascotaService.SearchById(id).getCliente().getcedula());
        return "modificar_mascota";
    }

    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota, @ModelAttribute("cedula") String cedula) {
        Cliente c = clienteService.findByCedula(cedula).get();
        if(c == null){
            return "redirect:/error/" + cedula;
        }else{
            mascota.setCliente(c);
            mascotaService.update(mascota);
            return "redirect:/mascotas/all";
        }
    }


    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") Long id) {
        mascotaService.delete(id);
        return "redirect:/mascotas/all";
    }

}
