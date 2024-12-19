package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.AdministradorService;
import com.example.demo.service.TratamientoService;
import com.example.demo.DTOs.AdministradorDTO;
import com.example.demo.DTOs.ClienteDTO;
import com.example.demo.DTOs.ClienteMapper;
import com.example.demo.DTOs.TratamientoDTO;
import com.example.demo.model.Administrador;
import com.example.demo.DTOs.AdministradorMapper;
import com.example.demo.model.Cliente;
import com.example.demo.model.Tratamiento;

@RequestMapping("/tratamiento")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {
    
    @Autowired
    TratamientoService tratamientoService;

    @Autowired
    AdministradorService administradorService;


    // METODO PARA ENCONTRAR TODOS LOS TRATAMIENTOS
    // url: http://localhost:8090/tratamiento/find/all
    @GetMapping("/find/all")
    public List<TratamientoDTO> mostrarTodosTratamientos() {
        return tratamientoService.findAll();
    }


    // METODO PARA ENCONTRAR UN TRATAMIENTO POR SU ID
    // url: http://localhost:8090/tratamiento/find/1
    @GetMapping("/find/{id}")
    public TratamientoDTO mostrarTratamiento(@PathVariable("id") Long id) {
        return tratamientoService.findById(id);
    }

    @GetMapping("/find/mascota/{id}")
    public List<TratamientoDTO> mostrarTratamientoMascota(@PathVariable("id") Long id) {
        return tratamientoService.findByMascotaId(id);
    }

    @GetMapping("/count")
    public Integer countTratamiento() {

        return tratamientoService.countTratamiento();
    }

    @GetMapping("/sum")
    public Integer sumTotalVentas() {
        return tratamientoService.sumTotalVentas();
    }


    // METODO PARA AGREGAR UN TRATAMIENTO
    // url: http://localhost:8090/tratamiento/add
    @PostMapping("/add")
    public TratamientoDTO agregarTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {
        return tratamientoService.add(tratamientoDTO);
    }


    // METODO PARA ACTUALIZAR UN TRATAMIENTO
    // url: http://localhost:8090/tratamiento/update
    @PutMapping("/update")
    public ResponseEntity<TratamientoDTO>updateTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {
        tratamientoService.updateTratamiento(tratamientoDTO);
        return new ResponseEntity<>(tratamientoDTO, HttpStatus.OK);
    }


    // METODO PARA ELIMINAR UN TRATAMIENTO POR SU ID
    // url: http://localhost:8090/tratamiento/delete/1
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        tratamientoService.deleteById(id);
    }
}
