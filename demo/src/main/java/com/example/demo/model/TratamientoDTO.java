package com.example.demo.model;

import java.util.Date;

public class TratamientoDTO {
    
    private Long id;
    private String nombreVeterinario;
    private Long idVeterinario;
    private String nombreMascota;
    private Long idMascota;
    private String nombreDroga;
    private Long idDroga;
    private int cantidad;
    private int unidadesDisponibles;
    private Date fechaConsulta;

    public TratamientoDTO(
        Long id, 
        String nombreVeterinario, 
        String nombreMascota, 
        String nombreDroga, 
        int cantidad, 
        Date fechaConsulta, 
        int unidadesDisponibles,
        Long idVeterinario,
        Long idMascota,
        Long idDroga
        ) {
        this.id = id;
        this.nombreVeterinario = nombreVeterinario;
        this.nombreMascota = nombreMascota;
        this.nombreDroga = nombreDroga;
        this.cantidad = cantidad;
        this.fechaConsulta = fechaConsulta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idDroga = idDroga;
    }

    public TratamientoDTO(String nombreVeterinario, String nombreMascota, String nombreDroga, int cantidad,
            Date fechaConsulta, int unidadesDisponibles, Long idVeterinario, Long idMascota, Long idDroga) {
        this.nombreVeterinario = nombreVeterinario;
        this.nombreMascota = nombreMascota;
        this.nombreDroga = nombreDroga;
        this.cantidad = cantidad;
        this.fechaConsulta = fechaConsulta;
        this.unidadesDisponibles = unidadesDisponibles;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idDroga = idDroga;
    }

    public TratamientoDTO() {
    }

    public Long getId() {
        return id;
    }

    

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdDroga() {
        return idDroga;
    }

    public void setIdDroga(Long idDroga) {
        this.idDroga = idDroga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDroga() {
        return nombreDroga;
    }

    public void setNombreDroga(String nombreDroga) {
        this.nombreDroga = nombreDroga;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    
}
