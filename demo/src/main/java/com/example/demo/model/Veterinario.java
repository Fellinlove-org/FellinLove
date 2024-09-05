package com.example.demo.model;


import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Veterinario {
    
    @Id
    @GeneratedValue
    private Long id;


    private String cedula;
    private String nombre;
    private String especialidad;
    private String correo;
    private String password;
    private String foto;


    @OneToMany(mappedBy = "veterinario")
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

    public Veterinario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
