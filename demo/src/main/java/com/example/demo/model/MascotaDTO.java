package com.example.demo.model;

public class MascotaDTO {
    private Mascota mascota;
    private String cedula;


    public MascotaDTO(Mascota m, String c) {
        this.mascota = m;
        this.cedula = c;
    }

    // Getters y Setters
    public Mascota getMascota() {
        return mascota;
    }



    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
