package com.example.demo.controler;

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
import com.example.demo.service.ClienteService;



@Controller
public class LandingController {
    

    @Autowired
    ClienteService clienteService;

    //http://localhost:8090/
    @GetMapping("/")
    public String mostarHomePage(Model model) {
        return "homePage";
    }
    @GetMapping("/Role")
    public String ElegirRole(Model model) {
        return "SeleccionarRole";
    }

    @GetMapping("/login")
    public String mostarLoginPage(Model model) {

        String cedula = "";

        model.addAttribute("cedula", cedula);

        return "Login";
    }

    @PostMapping("/loginUser")
    public String loginUsuario(@ModelAttribute("cedula") String cedula, Model model) {
        
        Optional<Cliente> cliente = clienteService.findByCedula(cedula);

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

        Optional<Cliente> cliente = clienteService.SearchById(id);

        if (cliente.isPresent()) {
            Cliente c = cliente.get();
            model.addAttribute("cliente", c);
            System.out.println("Cliente " + c.getNombre());
            return "homePageUsuario";
        }else {
            return "redirect:/error/" + id;
        }

    }

    @GetMapping("error/{cedula}")
    public String errorCedula(@PathVariable("cedula") String cedula, Model model) {
        model.addAttribute("cedula", cedula);
        return "error_cedula";
    }
    
    @GetMapping("errorUpdate/{cedula}")
    public String errorCedulaExistente(@PathVariable("cedula") String cedula, Model model) {
        model.addAttribute("cedula", cedula);
        return "error_cedula_existente";
    }
}
