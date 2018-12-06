package com.cgi.sdm_project.logica.juego.Reglas;

public class Pregunta {
    private String pregunta;
    private int tragos;

    public Pregunta(String pregunta, int tragos){
        this.pregunta = pregunta;
        this.tragos = tragos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public int getTragos() {
        return tragos;
    }
}
