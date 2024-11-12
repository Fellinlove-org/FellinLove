package com.example.demo.DTOs;

import lombok.Data;

@Data
public class AdministradorDTO {
    private Long id;
    private String cedula;
    private String nombre;
    private String password;
}
