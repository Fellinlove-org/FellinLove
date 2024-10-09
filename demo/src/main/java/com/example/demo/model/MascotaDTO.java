package com.example.demo.model;

public class MascotaDTO {
    private Mascota mascota;
    private Long id;


    public MascotaDTO(Mascota m, Long id) {
        this.mascota = m;
        this.id = id;
    }

    // Getters y Setters
    public Mascota getMascota() {
        return mascota;
    }



    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
