
package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

    private int cantidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "droga_id")
    private Droga droga;

    private Date fechaConsulta;


    public Tratamiento(Veterinario veterinario, Mascota mascota, Droga droga, Date fechaConsulta, int cantidad) {
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.droga = droga;
        this.fechaConsulta = fechaConsulta;
        this.cantidad = cantidad;
    }

    public Tratamiento(Long id, Veterinario veterinario, Mascota mascota, Droga droga, Date fechaConsulta, int cantidad) {
        this.id = id;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.droga = droga;
        this.fechaConsulta = fechaConsulta;
        this.cantidad = cantidad;
    }
   
    public Tratamiento(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
}