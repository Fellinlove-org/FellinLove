package com.example.demo.controler;

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
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;



@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

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
        Optional<Cliente> cliente = clienteService.findByCedula(cedula);
        System.out.println("cedula: " + cedula);

        if (cliente.isPresent()) {
            // Asiganar cliente
            Cliente c = cliente.get();
            mascota.setCliente(c);
            mascotaService.add(mascota);
            return "redirect:/mascotas/all";
        } else {
            //TODO: manejo de error
            return "homePage";
        }
        
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizarMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        model.addAttribute("cedula", mascotaService.SearchById(id).getCliente().getcedula());
        return "modificar_mascota";
    }

    @PostMapping("update/{id}")
    public String updateCliente(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota, @ModelAttribute("cedula") String cedula) {
        Cliente c = clienteService.findByCedula(cedula).get();
        if(c == null){
            return "redirect:/error/" + cedula;
        }else{
            mascota.setCliente(c);
            mascotaService.update(mascota);
            return "redirect:/mascotas/all";
        }
    }


    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") Long id) {
        mascotaService.delete(id);
        return "redirect:/mascotas/all";
    }

}
