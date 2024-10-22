package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.example.demo.service.TratamientoService;




@RequestMapping("/mascota")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TratamientoService tratamientoService;


    //METODO PARA ENCONTRAR A TODAS LAS MASCOTAS
    //url: http://localhost:8090/mascota/find/all
    @GetMapping("/find/all")
    public List<Mascota> mostrarTodasMascotas(Model model) {
        return mascotaService.SearchAll();
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR LA CEDULA DE SU DUEÑO
    //url: http://localhost:8090/mascota/cedula/030
    @GetMapping("/cedula/{cedula}")
    public List<Mascota> mostrarMascotaCedula(@PathVariable("cedula") String cedula) {
        Optional<Cliente> c = clienteService.findByCedula(cedula);
        if (c.isPresent()) {
            List<Mascota> mascotas = mascotaService.findByClienteId(c.get().getId());
            return mascotas;
        }
        return null;
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR EL ID DE SU DUEÑO
    //url: http://localhost:8090/mascota/cliente/30
    @GetMapping("/cliente/{id}")
    public List<Mascota> mostrarMascotaCliente(@PathVariable("id") Long id) {
        return mascotaService.findByClienteId(id);
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR SU ID
    //url: http://localhost:8090/mascota/find/1
    @GetMapping("/find/{id}")
    public Mascota mostrarMascota(@PathVariable("id") Long id) {
        return mascotaService.SearchById(id);
    }

    @GetMapping("/count/active")
    public Integer countActive() {
        return mascotaService.countActive();
    }


    //METODO PARA AGREGAR A UNA MASCOTA
    //url: http://localhost:8090/mascota/add
    @PostMapping("/add/{cedula}")
    public Mascota mostrarFormularioCrearMascota(@RequestBody Mascota mascota, @PathVariable("cedula") String cedula) {
        Optional<Cliente> c = clienteService.findByCedula(cedula);
        if (c.isPresent()) {
            mascota.setCliente(c.get());
            return mascotaService.add(mascota);
        }
        return null;
    }



    //METODO PARA ACTUALIZAR UNA MASCOTA
    //url: http://localhost:8090/mascota/update
    @PutMapping("/update/{cedula}")
    public Mascota updateCliente(@RequestBody Mascota mascota, @PathVariable("cedula") String cedula) {
        Optional<Cliente> c = clienteService.findByCedula(cedula);
        if (c.isPresent()) {
            mascota.setCliente(c.get());
            return mascotaService.update(mascota);
        }
        return null;
    }


    //METODO PARA BORRAR UNA MASCOTA POR SU ID
    //url: http://localhost:8090/mascota/delete/1
    @DeleteMapping("/delete/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        mascotaService.delete(id);
    }

}
