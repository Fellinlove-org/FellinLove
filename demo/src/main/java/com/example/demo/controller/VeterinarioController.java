package com.example.demo.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Veterinario;
import com.example.demo.service.VeterinarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RequestMapping("/veterinarios")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    public List<Veterinario> mostrarTodosveterinarios() {
        return veterinarioService.SearchAll();
    }


    @GetMapping("/search/{cedula}")
    public Optional<Veterinario> findByCedula(@PathVariable("cedula") String cedula) {
        return veterinarioService.findByCedula(cedula);
    }

    
}
