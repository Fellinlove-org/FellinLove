package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AdministradorService;

@RequestMapping("/admin")
@Controller
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    
    
}
