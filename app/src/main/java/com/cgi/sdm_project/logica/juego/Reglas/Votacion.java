package com.cgi.sdm_project.logica.juego.reglas;

import java.util.List;

public class Votacion extends ReglaTragable {
    private String[] opciones;
    private String texto;

    public Votacion(List<String> opciones, int tragos){
        super(tragos);
        this.opciones = (String[]) opciones.toArray();
    }

    public String[] getOpciones() {
        return opciones.clone();
    }

}
