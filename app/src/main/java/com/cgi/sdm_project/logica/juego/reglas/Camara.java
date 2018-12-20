package com.cgi.sdm_project.logica.juego.reglas;

public class Camara implements Regla {
    private String texto;

    public Camara(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
