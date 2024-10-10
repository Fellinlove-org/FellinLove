package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Administrador;
import com.example.demo.service.AdministradorService;

@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    
    @GetMapping("/search/{cedula}")
    public Optional<Administrador> findByCedula(@PathVariable("cedula") String cedula) {
        return administradorService.findByCedula(cedula);
    }
}
