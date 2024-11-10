package com.example.demo.DTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    
}
