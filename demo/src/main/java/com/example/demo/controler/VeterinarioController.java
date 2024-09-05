package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.VeterinarioService;

@RequestMapping("/veterinario")
@Controller

public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;
}
