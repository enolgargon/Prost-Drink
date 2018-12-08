package com.cgi.sdm_project.logica.juego.Reglas;

public class Votacion extends ReglaTragable {
    private String[] opciones;
    private String texto;

    public Votacion(String texto, String opcion1, String opcion2, int tragos) {
        super(tragos);
        this.texto = texto;
        this.opciones = new String[]{opcion1, opcion2};
    }

    public String[] getOpciones() {
        return opciones.clone();
    }

    public String getTexto() {
        return texto;
    }
}
