package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TratamientoService;
import com.example.demo.model.Tratamiento;

@RequestMapping("/tratamiento")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {
    
    @Autowired
    TratamientoService tratamientoService;

    // METODO PARA ENCONTRAR TODOS LOS TRATAMIENTOS
    // url: http://localhost:8090/tratamiento/find/all
    @GetMapping("/find/all")
    public List<Tratamiento> mostrarTodosTratamientos() {
        return tratamientoService.findAll();
    }


    // METODO PARA ENCONTRAR UN TRATAMIENTO POR SU ID
    // url: http://localhost:8090/tratamiento/find/1
    @GetMapping("/find/{id}")
    public Tratamiento mostrarTratamiento(@PathVariable("id") Long id) {
        return tratamientoService.findById(id);
    }


    // METODO PARA AGREGAR UN TRATAMIENTO
    // url: http://localhost:8090/tratamiento/add
    @PostMapping("/add")
    public void agregarTratamiento(@org.springframework.web.bind.annotation.RequestBody Tratamiento tratamiento) {
        tratamientoService.add(tratamiento);;
    }


    // METODO PARA ACTUALIZAR UN TRATAMIENTO
    // url: http://localhost:8090/tratamiento/update
    @PutMapping("/update")
    public void update(@org.springframework.web.bind.annotation.RequestBody Tratamiento tratamiento) {
        tratamientoService.update(tratamiento);
    }


    // METODO PARA ELIMINAR UN TRATAMIENTO POR SU ID
    // url: http://localhost:8090/tratamiento/delete/1
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        tratamientoService.deleteById(id);
    }
}