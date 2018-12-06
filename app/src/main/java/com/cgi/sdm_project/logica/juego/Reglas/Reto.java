package com.cgi.sdm_project.logica.juego.Reglas;

public class Reto {
    private String texto;
    private int tragos;

    public Reto(String texto, int tragos){
        this.texto = texto;
        this.tragos = tragos;
    }

    public String getTexto() {
        return texto;
    }

    public int getTragos() {
        return tragos;
    }
}
