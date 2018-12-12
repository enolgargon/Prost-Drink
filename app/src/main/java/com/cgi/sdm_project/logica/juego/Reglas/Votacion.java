package com.cgi.sdm_project.logica.juego.reglas;

import java.util.ArrayList;
import java.util.List;

public class Votacion extends ReglaTragable {
    private String[] opciones;
    private String texto;


    public Votacion(List<String> opciones, int tragos, String texto){

        super(tragos);
        ArrayList<String> aux = new ArrayList<>(opciones);
        this.texto = texto;
        this.opciones = new String[aux.size()];
        for (int i = 0; i < aux.size(); i++)
            this.opciones[i] = aux.get(i);
    }

    public String[] getOpciones() {
        return opciones.clone();
    }

    public String getTexto(){ return texto;}

    public void votar(int i) {
        //TODO implementar el metodo para almacenar los votos
    }
}
