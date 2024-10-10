package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Administrador;
import com.example.demo.model.Cliente;
import com.example.demo.model.Veterinario;
import com.example.demo.service.AdministradorService;
import com.example.demo.service.ClienteService;
import com.example.demo.service.VeterinarioService;

import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LandingController {
    

    @Autowired
    ClienteService clienteService;

    @Autowired
    AdministradorService administradorService;

    @Autowired
    VeterinarioService veterinarioService;

    //http://localhost:8090/
    @GetMapping("/")
    public String mostarHomePage(Model model) {
        return "homePage";
    }
    @GetMapping("/Role")
    public String ElegirRole(Model model) {
        return "SeleccionarRole";
    }

    @GetMapping("/loginAdmin")
    public String mostrarLoginAdmin(Model model) {

        String cedula = "";
        String password = "";
        model.addAttribute("cedula", cedula);
        model.addAttribute("password", password);

        return "login_admin";
    }

    @GetMapping("/loginVeterinario")
    public String mostrarLoginVeterinario(Model model) {

        String cedula = "";
        String password = "";
        model.addAttribute("cedula", cedula);
        model.addAttribute("password", password);

        return "login_veterinario";
    }

    @GetMapping("/login/{cedula}")
    public ResponseEntity<Map<String, String>> loginUser(@PathVariable("cedula") String cedula) {

        Optional<Cliente> cliente = clienteService.findByCedula(cedula);

        Map<String, String> response = new HashMap<>();

        if(!cliente.isPresent()){
            Optional<Veterinario> veterinario = veterinarioService.findByCedula(cedula);
            if (!veterinario.isPresent()) {
                Optional<Administrador> admin = administradorService.findByCedula(cedula);
                if (!admin.isPresent()) {
                    response.put("userType", "notFound");
                    return ResponseEntity.ok(response);
                }else{
                    response.put("userType", "administrador");
                    return ResponseEntity.ok(response);
                }
            }else{
                response.put("userType", "veterinario");
                return ResponseEntity.ok(response);
            }
        }else{
            response.put("userType", "cliente");
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/loginAdmin")
    public String loginAdministrador(@ModelAttribute("cedula") String cedula, @ModelAttribute("password") String password, Model model) {
        
        Optional<Administrador> admin = administradorService.findByCedula(cedula);

        if (admin.isPresent() && admin.get().getPassword().equals(password)) {
            // Asiganar cliente
            Administrador a = admin.get();
            model.addAttribute("admin", a);
            return "redirect:/inicioAdmin/" + a.getId();
        } else {
            //TODO: mostrar error inicio de sesion
            model.addAttribute("cliente", "");
            return "redirect:/";
        }
    }

    @PostMapping("/loginVeterinario")
    public String logindeVeterinaro(@ModelAttribute("cedula") String cedula, @ModelAttribute("password") String password, Model model) {
        Optional<Veterinario> veterinario = veterinarioService.findByCedula(cedula);

        if (veterinario.isPresent() && veterinario.get().getPassword().equals(password)) {

            // Asiganar
            Veterinario v = veterinario.get();
            model.addAttribute("veterinario", v);
            return "redirect:/inicioVeterinario/" + v.getId();
        } else {
            //TODO: mostrar error inicio de sesion
            model.addAttribute("cliente", "");
            return "redirect:/";
        }
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

    @GetMapping("/inicioAdmin/{id}")
    public String inicioAdmin(Model model, @PathVariable("id") Long id) {

        Optional<Administrador> admin = administradorService.SearchById(id);

        if (admin.isPresent()) {
            Administrador a = admin.get();
            model.addAttribute("admin", a);
            System.out.println("Administrador " + a.getNombre());
            return "homePageAdmin";
        }else {
            //TODO: mandar a pagina de error que no se inicio sesion
            return "redirect:/error/" + id;
        }

    }

    @GetMapping("/inicioVeterinario/{id}")
    public String inicioVet(Model model, @PathVariable("id") Long id) {

        Optional<Veterinario> vet = veterinarioService.SearchById(id);

        if (vet.isPresent()) {
            Veterinario v = vet.get();
            model.addAttribute("vet", v);
            System.out.println("Veterinario " + v.getNombre());
            return "homePageVet";
        }else {
            //TODO: mandar a pagina de error que no se inicio sesion
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
