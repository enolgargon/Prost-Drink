package com.cgi.sdm_project.logica.juego.Reglas;

public class Pregunta extends ReglaTragable {
    private String pregunta;
    private boolean contestada;

    public Pregunta(String pregunta, int tragos) {
        super(tragos);
        this.pregunta = pregunta;
    }

    public void contestar() {
        contestada = true;
    }

    public void pasar() {
        contestada = false;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isContestada() {
        return contestada;
    }
}
