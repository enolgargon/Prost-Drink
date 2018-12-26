package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.Regla;

public class Camara implements Regla {
    private String texto;

    public Camara(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
