package com.cgi.sdm_project.logica.juego.Reglas;

public class Pregunta extends ReglaTragable {
    private String pregunta;

    public Pregunta(String pregunta, int tragos){
        super(tragos);
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }
}
