package com.example.demo.controller;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.model.Veterinario;
import com.example.demo.service.TratamientoService;
import com.example.demo.service.VeterinarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    TratamientoService tratamientoService;


    @GetMapping("/login/{cedula}/{password}")
    public ResponseEntity login(@PathVariable("cedula") String cedula, @PathVariable("password") String password) {
        Optional<Veterinario> veterinario = veterinarioService.findByCedula(cedula);
        if (!veterinario.isPresent()) {
            return new ResponseEntity<>("Cedula o password incorrectos", HttpStatus.UNAUTHORIZED);
        }else if(!veterinario.get().getPassword().equals(password)){
            return new ResponseEntity<>("Cedula o password incorrectos", HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>("""
                {
                    "msg":"Acceso permitido"
                }
                """, HttpStatus.ACCEPTED);
        }
    }

    //METODO PARA ENCONTRAR A TODOS LOS VETERINARIOS
    //url: http://localhost:8090/veterinario/find/all
    @GetMapping("/find/all")
    public List<Veterinario> mostrarTodosveterinarios() {
        return veterinarioService.SearchAll();
    }


    //METODO PARA ENCONTRAR A UN VETERINARIO POR SU ID
    //url: http://localhost:8090/veterinario/find/1
    @GetMapping("/find/{id}")
    public Optional<Veterinario> SearchById(@PathVariable("id") Long id) {
        return veterinarioService.SearchById(id);
    }


    //METODO PARA ENCONTRAR A UN VETERINARIO POR SU CEDULA
    //url: http://localhost:8090/veterinario/find/cedula
    @GetMapping("/find/cedula/{cedula}")
    public Optional<Veterinario> findByCedula(@PathVariable("cedula") String cedula) {
        return veterinarioService.findByCedula(cedula);
    }


    //METODO PARA AGREGAR A UN VETERINARIO
    //url: http://localhost:8090/veterinario/add
    @PostMapping("/add")
    public void agregarVeterinario(@org.springframework.web.bind.annotation.RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }


    //METODO PARA ACTUALIZAR UN VETERINARIO
    //url: http://localhost:8090/veterinario/update
    @PutMapping("/update")
    public void update(@org.springframework.web.bind.annotation.RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }

    
    //METODO PARA ELIMINAR UN VETERINARIO POR SU ID
    //url: http://localhost:8090/veterinario/delete/1
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);;
    }
}
