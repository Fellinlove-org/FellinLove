package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Veterinario;
import com.example.demo.service.VeterinarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    public String mostrarTodosveterinarios(Model model) {
        model.addAttribute("veterinario", veterinarioService.SearchAll());

        return "mostrar_todos_veterinario";
    }


    @GetMapping("/search/{cedula}")
    public Optional<Veterinario> findByCedula(@PathVariable("cedula") String cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    
}
