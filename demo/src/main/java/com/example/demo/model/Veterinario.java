package com.example.demo.model;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
    
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @Id
    @GeneratedValue
    private Long id;


    private String cedula;
    private String nombre;
    private String especialidad;
    private String correo;
    private String password;
    private String foto;


    @JsonIgnore
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Veterinario(Long id, String cedula, String nombre, String especialidad,String correo, String password, String foto) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
    }

    public Veterinario(String cedula, String nombre,String especialidad, String correo, String password, String foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
    }

}
