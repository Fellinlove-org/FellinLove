package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Tratamiento;
import com.example.demo.repository.TratamientoRepository;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoControler {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @PostMapping
    public Tratamiento createTratamiento(@RequestBody Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    @GetMapping("/{id}")
    public Tratamiento getTratamiento(@PathVariable Long id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTratamiento(@PathVariable Long id) {
        tratamientoRepository.deleteById(id);
    }
}
