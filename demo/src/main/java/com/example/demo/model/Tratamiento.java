package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Tratamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private LocalDate fecha;

   
    @ManyToOne
    private Mascota mascota;
    @ManyToOne
    private Veterinario veterinario;
    @ManyToOne
    private Droga droga;



    public Tratamiento(Long id, String nombre, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    

    // Constructor con parámetros para asociar mascota, veterinario y droga
    public Tratamiento(String nombre, LocalDate fecha, Mascota mascota, Veterinario veterinario, Droga droga) {
    this.nombre = nombre;
    this.fecha = fecha;
    this.mascota = mascota;
    this.veterinario = veterinario;
    this.droga = droga;
}

    public Tratamiento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

  

    // Constructor, getters y setters
    public Tratamiento() {}
    


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


 
}
