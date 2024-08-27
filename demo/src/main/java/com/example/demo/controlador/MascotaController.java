package com.example.demo.controlador;

import java.util.Collection;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.MascotaService;



@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/all")
    public String mostrarTodasMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrearMascota(Model model){
        
        Mascota mascota = new Mascota("", "", 0, 0, "", "");
        String cedula = "";
        model.addAttribute("mascota", mascota);
        model.addAttribute("cedula", cedula);
        return "agregar_mascota";
    }
    
    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota, @ModelAttribute("cedula") String cedula) {
        
        //buscar cliente
        Optional<Cliente> cliente = clienteRepository.findByCedula("123456");

        if (cliente.isPresent()) {
            // Haz algo con el cliente
            Cliente c = cliente.get();
            mascota.setCliente(c);
            mascotaService.add(mascota);
            return "redirect:/mascotas/all";
        } else {
            return "homePage";
        }
        
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "modificar_mascota";
    }

    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota) {
        mascotaService.update(mascota);
        return "redirect:/mascotas/all";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") Long id) {
        mascotaService.delete(id);
        return "redirect:/mascotas/all";
    }

}
