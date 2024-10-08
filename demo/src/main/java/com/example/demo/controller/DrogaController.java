package com.example.demo.controller;

import com.example.demo.model.Droga;
import com.example.demo.repository.DrogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/drogas")
public class DrogaController {

    @Autowired
    private DrogaRepository drogaRepository;

    @PostMapping
    public Droga createDroga(@RequestBody Droga droga) {
        return drogaRepository.save(droga);
    }

    @GetMapping("/{id}")
    public Droga getDroga(@PathVariable Long id) {
        return drogaRepository.findById(id).orElse(null);
    }

   @GetMapping
    public List<Droga> getAllDrogas() {
        return drogaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteDroga(@PathVariable Long id) {
        drogaRepository.deleteById(id);
    }
}
