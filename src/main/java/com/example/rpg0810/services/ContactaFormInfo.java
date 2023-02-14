package com.example.rpg0810.services;

public class ContactaFormInfo {

    private String nombre;
    private String email;
    private String opcion;
    private String texto;
    private boolean condiciones;


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpcion() {
        return this.opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCondiciones() {
        return this.condiciones;
    }

    public boolean getCondiciones() {
        return this.condiciones;
    }

    public void setCondiciones(boolean condiciones) {
        this.condiciones = condiciones;
    }
    
    
}