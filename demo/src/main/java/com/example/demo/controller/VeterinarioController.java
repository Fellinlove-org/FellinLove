package com.example.demo.controller;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTOs.VeterinarioDTO;
import com.example.demo.DTOs.VeterinarioMapper;
import com.example.demo.model.Veterinario;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.TratamientoService;
import com.example.demo.service.VeterinarioService;


import com.example.demo.model.UserEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;



@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    TratamientoService tratamientoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTGenerator jwtGenerator;


    /*@GetMapping("/login/{cedula}/{password}")
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
    }*/


     @PostMapping("/login")
    public ResponseEntity loginVeterinarioEntity(@RequestBody VeterinarioDTO veterinarioDTO) {

        System.out.println("VETERINARIO DTO: " + veterinarioDTO);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(veterinarioDTO.getCedula(), veterinarioDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<VeterinarioDTO> getDetails() {
        
        Veterinario veterinario = veterinarioService.findByCedula(
            SecurityContextHolder.getContext().getAuthentication().getName()
        ).get();

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(veterinario);

        if( veterinario == null ) {
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
    }

    @GetMapping("/best")
    public ResponseEntity<VeterinarioDTO> getEmpleadoMes(){
        Veterinario vet = veterinarioService.getEmpleadoMes();

        VeterinarioDTO veterinarioDTO = VeterinarioMapper.INSTANCE.convert(vet);

        if(vet == null){
            return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VeterinarioDTO>(veterinarioDTO, HttpStatus.OK);
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

    public ResponseEntity agregarVeterinario (@RequestBody Veterinario veterinario) {

        if (userRepository.existsByUsername(veterinario.getCedula())) {
            return new ResponseEntity<String>("Este veterinario ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.VetToUser(veterinario);
        veterinario.setUser(userEntity);
        Veterinario vetDB = veterinarioService.add(veterinario);
        VeterinarioDTO newVet = VeterinarioMapper.INSTANCE.convert(vetDB);

        if (newVet == null) {
            return new ResponseEntity<VeterinarioDTO>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<VeterinarioDTO>(newVet, HttpStatus.CREATED);

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
