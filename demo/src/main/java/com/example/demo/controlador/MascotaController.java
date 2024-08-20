package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entidad.Mascota;
import com.example.demo.servicio.MascotaService;



@RequestMapping("/mascotas")
@Controller
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/all")
    public String mostrarTodasMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.SearchAll());
        return "mostrar_todas_mascotas";
    }

    @GetMapping("/find/{id}")
    public String mostrarMascota(Model model, @PathVariable("id") int id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota";
    }

    @GetMapping("/add")
    public String mostrarFormularioCrearMascota(Model model){
        
        Mascota mascota = new Mascota(0, "", "", 0, 0, "", "");

        model.addAttribute("mascota", mascota);
        
        return "agregar_mascota";
    }
    
    @PostMapping("/agregar")
    public String agregarMascota(@ModelAttribute("mascota") Mascota mascota){
        
        mascotaService.add(mascota);
        return "redirect:/mascotas/all";
    }

    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizarMascota(Model model, @PathVariable("id") int id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "actualizar_mascota";
    }

    @GetMapping("/delete/{id}")
    public String borrarMascota(@PathVariable("id") int id) {
        mascotaService.delete(id);
        return "redirect:/mascotas/all";
    }

}
