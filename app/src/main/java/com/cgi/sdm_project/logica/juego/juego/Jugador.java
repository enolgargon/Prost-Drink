package com.cgi.sdm_project.logica.juego.juego;

import android.support.annotation.NonNull;

public class Jugador {

    private String nombre;

    public Jugador(String nombre){
        if (nombre != null)
            this.nombre = nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
