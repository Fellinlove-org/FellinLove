package com.example.demo.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;



@Controller
public class LandingController {
    

    @Autowired
    ClienteRepository clienteRepository;

    //http://localhost:8090/
    @GetMapping("/")
    public String mostarHomePage(Model model) {
        return "homePage";
    }

    @GetMapping("/login")
    public String mostarLoginPage(Model model) {

        String cedula = "";

        model.addAttribute("cedula", cedula);

        return "Login";
    }

    @PostMapping("/loginUser")
    public String loginUsuario(@ModelAttribute("cedula") String cedula, Model model) {
        
        Optional<Cliente> cliente = clienteRepository.findByCedula(cedula);

        if (cliente.isPresent()) {
            // Asiganar cliente
            Cliente c = cliente.get();
            model.addAttribute("cliente", c);
            return "redirect:/inicio/" + c.getId();
        } else {
            model.addAttribute("cliente", "");
            return "redirect:/";
        }
    }

    @GetMapping("/inicio/{id}")
    public String inicioUser(Model model, @PathVariable("id") Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            model.addAttribute("cliente", c);
            System.out.println("Cliente " + c.getNombre());
            return "homePageUsuario";
        }else {
            //TODO: mandar a pagina de error que no se inicio sesion
            return "redirect:/";
        }

    }

    
    
}
