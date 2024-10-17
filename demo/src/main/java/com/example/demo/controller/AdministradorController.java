package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Administrador;
import com.example.demo.model.Veterinario;
import com.example.demo.service.AdministradorService;

@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    
   
    

    @GetMapping("/find/cedula/{cedula}")
    public Optional<Administrador> findByCedula(@PathVariable("cedula") String cedula) {
        return administradorService.findByCedula(cedula);
    }

    @GetMapping("/login/{cedula}/{password}")
    public ResponseEntity<Map<String, String>> login(@PathVariable("cedula") String cedula, @PathVariable("password") String password) {
        Optional<Administrador> admin = administradorService.findByCedula(cedula);
        Map<String, String> response = new HashMap<>();
        if (!admin.isPresent()) {
            response.put("msg", "Cédula o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }else if(!admin.get().getPassword().equals(password)){
            response.put("msg", "Cédula o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }else{
            response.put("msg", "ok");
            return ResponseEntity.ok(response);
        }
    }
}
