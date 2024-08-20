package com.example.demo.entidad;

public class Cliente {
    private Integer id;
    private Integer Cedula;
    private String Nombre;
    private String correo;
    private String celular;
    private String foto;
    
    public Cliente(Integer id,Integer Cedula, String Nombre, String correo, String celular, String foto) {
        this.id = id;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
}
