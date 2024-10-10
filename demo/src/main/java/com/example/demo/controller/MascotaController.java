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
    public String mostrarTodasMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
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
        //mascotaService.add(mascota);
        //if (cliente.isPresent()) {
            // Asiganar cliente
            //Cliente c = cliente.get();
            //mascota.setCliente(c);
            //mascotaService.add(mascota);
            
        //}
    }
        
            
        
    
    @PostMapping("/prueba")
    public MascotaDTO mostrarPrueba(@org.springframework.web.bind.annotation.RequestBody MascotaDTO mascotaDTO) {
        if (mascotaDTO != null) {
            System.out.println("MascotaDTO no es null");
            System.out.println("Mascota: " + mascotaDTO.getMascota().toString());
            System.out.println("Cédula: " + mascotaDTO.getId());
            return mascotaDTO;
        } else {
            System.out.println("MascotaDTO es null");
            return null;
        }
    }


    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        model.addAttribute("cedula", mascotaService.SearchById(id).getCliente().getcedula());
        return "modificar_mascota";
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
            tratamientoService.delete(t.getId());
        }
        mascotaService.delete(id);
    }

}
