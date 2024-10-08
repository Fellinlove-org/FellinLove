package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.VeterinarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@RequestMapping("/veterinario")
@Controller

public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    public String mostrarTodosveterinarios(Model model) {
        model.addAttribute("veterinario", veterinarioService.SearchAll());

        return "mostrar_todos_veterinario";
    }
    
}
