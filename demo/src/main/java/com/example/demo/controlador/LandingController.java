package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LandingController {
    

    //http://localhost:8090/
    @GetMapping("/")
    public String mostarHomePage() {
        return "homePage";
    }
    
}
