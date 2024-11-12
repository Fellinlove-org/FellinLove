package com.example.demo.DTOs;

import lombok.Data;

@Data
public class DrogaDTO {
    private int id;
    private String nombre;
    private int unidadesDisponibles;
    private String link;
}
