package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Cliente;
import com.example.demo.model.Mascota;
import com.example.demo.model.Tratamiento;
import com.example.demo.service.ClienteService;
import com.example.demo.service.MascotaService;
import com.example.demo.service.TratamientoService;




@RequestMapping("/mascota")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    TratamientoService tratamientoService;


    //METODO PARA ENCONTRAR A TODAS LAS MASCOTAS
    //url: http://localhost:8090/mascota/find/all
    @GetMapping("/find/all")
    public List<Mascota> mostrarTodasMascotas(Model model) {
        return mascotaService.SearchAll();
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR LA CEDULA DE SU DUEÑO
    //url: http://localhost:8090/mascota/cedula/030
    @GetMapping("/cedula/{cedula}")
    public List<Mascota> mostrarMascotaCedula(@PathVariable("cedula") String cedula) {
        Optional<Cliente> c = clienteService.findByCedula(cedula);
        if (c.isPresent()) {
            List<Mascota> mascotas = mascotaService.findByClienteId(c.get().getId());
            return mascotas;
        }
        return null;
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR EL ID DE SU DUEÑO
    //url: http://localhost:8090/mascota/cliente/30
    @GetMapping("/cliente/{id}")
    public List<Mascota> mostrarMascotaCliente(@PathVariable("id") Long id) {
        return mascotaService.findByClienteId(id);
    }


    //METODO PARA ENCONTRAR A UNA MASCOTA POR SU ID
    //url: http://localhost:8090/mascota/find/1
    @GetMapping("/find/{id}")
    public Mascota mostrarMascota(@PathVariable("id") Long id) {
        return mascotaService.SearchById(id);
    }


    //METODO PARA AGREGAR A UNA MASCOTA
    //url: http://localhost:8090/mascota/add
    @PostMapping("/add")
        public String mostrarFormularioCrearMascota(@RequestBody Mascota mascota){
        if (mascota == null) {
            System.out.println("EL JSON ES NULL");
            return "EL JSON ES NULL";
        }
        
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Cliente: " + mascota.getCliente());
        
        if (mascota.getCliente() == null) {
            System.out.println("El cliente es NULL");
            return "El cliente es NULL";
        } else {
            mascotaService.add(mascota);
            return "MASCOTA AGREGADA CORRECTAMENTE";
    }
}



    //METODO PARA ACTUALIZAR UNA MASCOTA
    //url: http://localhost:8090/mascota/update
    @PutMapping("/update")
    public void updateCliente(@RequestBody Mascota mascota) {
        if (mascota == null) {
            System.out.println("EL JSON ES NULL");
            return;
        }else{
            mascotaService.update(mascota);
        }
    }


    //METODO PARA BORRAR UNA MASCOTA POR SU ID
    //url: http://localhost:8090/mascota/delete/1
    @DeleteMapping("/delete/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        List<Tratamiento> listTratamieto = tratamientoService.findByMascotaId(id);
        for (Tratamiento t : listTratamieto) {
            tratamientoService.deleteById(t.getId());
        }
        mascotaService.delete(id);
    }

}
