package com.cgi.sdm_project.logica.juego.Reglas;

public class Votacion {
    private String[] opciones;
    private String texto;
    private int tragos;

    public Votacion(String opcion1, String opcion2, int tragos){
        this.opciones = new String[]{opcion1, opcion2};
        this.tragos = tragos;
    }

    public String[] getOpciones() {
        return opciones.clone();
    }

    public int getTragos() {
        return tragos;
    }
}
