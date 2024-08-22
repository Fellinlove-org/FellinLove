package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private Integer Cedula;
    private String Nombre;
    private String correo;
    private String celular;
    private String foto;

    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas = new ArrayList<>();
    
    public Cliente(Long id,Integer Cedula, String Nombre, String correo, String celular, String foto) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    public Cliente(Integer Cedula, String Nombre, String correo, String celular, String foto) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFoto() {    
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    

    
}
