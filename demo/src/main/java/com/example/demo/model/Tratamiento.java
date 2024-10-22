
package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    private Long id;

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

    

    public Tratamiento(Veterinario veterinario, Mascota mascota, Droga droga, Date fechaConsulta) {
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.droga = droga;
        this.fechaConsulta = fechaConsulta;
    }

    public Tratamiento(Long id, Veterinario veterinario, Mascota mascota, Droga droga, Date fechaConsulta) {
        this.id = id;
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.droga = droga;
        this.fechaConsulta = fechaConsulta;
    }

    public Tratamiento() {
    }

    public Tratamiento(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }
}