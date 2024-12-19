package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.AdministradorDTO;
import com.example.demo.model.Administrador;
import com.example.demo.DTOs.AdministradorMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.AdministradorService;

@RequestMapping("/admin")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    
   @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @Autowired
    private UserRepository userRepository;
    

    @GetMapping("/find/cedula/{cedula}")
    public Optional<Administrador> findByCedula(@PathVariable("cedula") String cedula) {
        return administradorService.findByCedula(cedula);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdministradorDTO administradorDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(administradorDTO.getCedula(), administradorDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<AdministradorDTO> getDetails() {
        
        Administrador administrador = administradorService.findByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        ).get();

        AdministradorDTO administradorDTO = AdministradorMapper.INSTANCE.convert(administrador);

        if( administrador == null ) {
            return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AdministradorDTO>(administradorDTO, HttpStatus.OK);
    }
}
