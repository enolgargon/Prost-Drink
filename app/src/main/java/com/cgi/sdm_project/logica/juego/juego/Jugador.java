package com.cgi.sdm_project.logica.juego.juego;

public class Jugador {

    private String nombre;

    public Jugador(String nombre){
        if (nombre != null)
            this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
