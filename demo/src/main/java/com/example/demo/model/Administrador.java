package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrador {

    @Id
    @GeneratedValue
    private Long id;

    private String cedula;
    private String nombre;
    private String correo;
    private String password;

    public Administrador(Long id, String cedula, String nombre, String correo, String password) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Administrador(String cedula, String nombre, String correo, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Administrador() {

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

    
}
