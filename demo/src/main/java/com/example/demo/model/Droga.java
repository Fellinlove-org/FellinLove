package com.example.demo.model;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Droga {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private float precio;
    private float precioVenta;
    private Integer unidadesDispo;
    private Integer UnidadesVenta;

     @OneToMany(mappedBy = "droga")
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Droga() {

    }

    public Droga(Long id, String nombre, float precio, float precioVenta, Integer unidadesDispo, Integer unidadesVenta) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.precioVenta = precioVenta;
        this.unidadesDispo = unidadesDispo;
        UnidadesVenta = unidadesVenta;
    }

    public Droga(String nombre, float precio, float precioVenta, Integer unidadesDispo, Integer unidadesVenta) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioVenta = precioVenta;
        this.unidadesDispo = unidadesDispo;
        UnidadesVenta = unidadesVenta;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getUnidadesDispo() {
        return unidadesDispo;
    }

    public void setUnidadesDispo(Integer unidadesDispo) {
        this.unidadesDispo = unidadesDispo;
    }

    public Integer getUnidadesVenta() {
        return UnidadesVenta;
    }

    public void setUnidadesVenta(Integer unidadesVenta) {
        UnidadesVenta = unidadesVenta;
    }
    
    

}