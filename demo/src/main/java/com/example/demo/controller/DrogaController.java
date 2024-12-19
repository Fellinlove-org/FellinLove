package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Droga;
import com.example.demo.service.DrogaService;

@RestController
@RequestMapping("/drogas")
@CrossOrigin("http://localhost:4200")
public class DrogaController {

    @Autowired
    private DrogaService drogaService;

    // http://localhost:8090/drogas/ver
    @GetMapping("/all")
    public List<Droga> verDrogas() {
        return drogaService.SearchAll();
    }

    // http://localhost:8090/drogas/ver/%7Bid%7D
    @GetMapping("/find/{id}")
    public Droga verDroga(@PathVariable("id") Long id) {
        return drogaService.SearchById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Droga> modificarDroga(@RequestBody Droga droga) {
        drogaService.update(droga);
        return new ResponseEntity<>(droga, HttpStatus.OK);
    }

    // http://localhost:8090/drogas/ventas-totales
    @GetMapping("/ventas-totales")
    public ResponseEntity<Double> getVentasTotales() {
        Double ventas = drogaService.getVentasTotales();
        return ResponseEntity.ok(ventas);
    }

    // http://localhost:8090/drogas/ganancias-totales
    @GetMapping("/ganancias-totales")
    public ResponseEntity<Double> getGananciasTotales() {
        Double ganancias = drogaService.getGananciasTotales();
        return ResponseEntity.ok(ganancias);
    }

    // http://localhost:8090/drogas/top3
    @GetMapping("/top3")
    public List<Object[]> getTopTratamientos() {
        return drogaService.getTopTratamientos();
    }

    @GetMapping("/escasas")
    public List<Droga> findDrogasParaCompra() {
        return drogaService.findDrogasParaCompra();
    }
}
