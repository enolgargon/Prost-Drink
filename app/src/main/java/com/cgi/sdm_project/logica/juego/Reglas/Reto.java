package com.cgi.sdm_project.logica.juego.Reglas;

public class Reto extends Regla {
    private String texto;

    public Reto(String texto, int tragos){
        super(tragos);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
