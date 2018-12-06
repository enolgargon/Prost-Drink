package com.cgi.sdm_project.logica.juego.Reglas;

public class Pregunta extends Regla {
    private String pregunta;

    public Pregunta(String pregunta, int tragos){
        super(tragos);
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }
}
