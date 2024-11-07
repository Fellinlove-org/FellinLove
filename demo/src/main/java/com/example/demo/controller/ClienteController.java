package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DTOs.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JWTGenerator;
import com.example.demo.service.ClienteService;
import com.example.demo.model.UserEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("/cliente")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTGenerator jwtGenerator;

    @Autowired
    private UserRepository userRepository;


    //METODO PARA ENCONTRAR A UN CLIENTE POR SI ID
    //url: http://localhost:8090/cliente/find/1
    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.SearchById(id);
        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
    }


    //METODO PARA ENCONTRAR A UN CLIENTE POR SU CEDULA
    //url: http://localhost:8090/cliente/find/cedula
    @GetMapping("/find/cedula/{cedula}")
    public ResponseEntity<Cliente> findByCedula(@PathVariable("cedula") String cedula) {
        Cliente cliente = clienteService.findByCedula(cedula);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
    }


     // http://localhost:8080/clientes/login
    @PostMapping("/login")
    public ResponseEntity<String> loginClienteEntity(@RequestBody ClienteDTO clienteDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(clienteDTO.getCedula(), "123"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }



    //METODO PARA ENCONTRAR A TODOS LOS CLIENTES
    //url: http://localhost:8090/cliente/find/all
    @GetMapping("/find/all")
    public ResponseEntity<List<Cliente>> mostrarTodosClientes() {
        List<Cliente> clientes = clienteService.SearchAll();
        ResponseEntity<List<Cliente>> response = new ResponseEntity<>(clientes, HttpStatus.OK);
        return response;
    }


    //METODO PARA AGREGAR A UN CLIENTE
    //url: http://localhost:8090/cliente/add
    @PostMapping("/add")
    
    public ResponseEntity agregarCliente(@RequestBody Cliente cliente) {

        if (userRepository.existsByUsername(cliente.getCedula())) {
            return new ResponseEntity<String>("Este cliente ya existe", HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = customUserDetailService.ClienteToUser(cliente);
        cliente.setUser(userEntity);
        Cliente newCliente = clienteService.add(cliente);
        if (newCliente == null) {
            return new ResponseEntity<Cliente>(newCliente,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);

    }


    //METODO PARA ACTUALIZAR UN CLIENTE
    //url: http://localhost:8090/cliente/update
    @PutMapping("update")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        clienteService.update(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    

    //METODO PARA BORRAR UN CLIENTE
    //url: http://localhost:8090/cliente/delete/1
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return new ResponseEntity<>("DELETED", HttpStatus.NO_CONTENT);
    }
    

}
