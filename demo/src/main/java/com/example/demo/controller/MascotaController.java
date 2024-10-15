package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.model.MascotaDTO;
import com.example.demo.model.Tratamiento;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.example.demo.service.TratamientoService;




@RequestMapping("/mascotas")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TratamientoService tratamientoService;


    @GetMapping("/all")
    public List<Mascota> mostrarTodasMascotas(Model model) {
        return mascotaService.SearchAll();
    }

    @GetMapping("/cedula/{cedula}")
    public List<Mascota> mostrarMascotaCedula(@PathVariable("cedula") String cedula) {
        Optional<Cliente> c = clienteService.findByCedula(cedula);
        if (c.isPresent()) {
            List<Mascota> mascotas = mascotaService.findByClienteId(c.get().getId());
            return mascotas;
        }
        return null;
    }

    @GetMapping("/find/{id}")
    public Mascota mostrarMascota(@PathVariable("id") Long id) {
        return mascotaService.SearchById(id);
    }

    @GetMapping("/search/{id}")
    public List<Mascota> buscarMascota(@PathVariable("id") Long id) {
        return mascotaService.findByClienteId(id);
    }

    @PostMapping("/add")
    public void mostrarFormularioCrearMascota(@org.springframework.web.bind.annotation.RequestBody MascotaDTO mascotaDTO){
        if (mascotaDTO == null) {
            System.out.println("EL JSON ES NULL");
            return;
        }else{
            System.out.println("mascota DTO: " +mascotaDTO.getMascota().toString());
            System.out.println("cedula: " + mascotaDTO.getId().toString());
            mascotaService.add(mascotaDTO.getMascota(), mascotaDTO.getId());
        }
    }

    @PostMapping("/update")
    public void updateCliente(@org.springframework.web.bind.annotation.RequestBody MascotaDTO mascotaDTO) {
        Long id = mascotaDTO.getId();
        Mascota mascota = mascotaDTO.getMascota();
        Optional<Cliente> c = clienteService.SearchById(id);
        if(c.isPresent()){
            mascota.setCliente(c.get());
            mascotaService.update(mascota);
        }
    }


    @GetMapping("/delete/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        List<Tratamiento> listTratamieto = tratamientoService.findByMascotaId(id);
        for (Tratamiento t : listTratamieto) {
            tratamientoService.deleteById(t.getId());
        }
        mascotaService.delete(id);
    }

}
