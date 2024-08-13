package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.servicio.MascotaService;


@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String mostrarTodasMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") int id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota";
    }
    

}
