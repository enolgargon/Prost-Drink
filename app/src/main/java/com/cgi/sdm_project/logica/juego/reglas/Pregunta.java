package com.cgi.sdm_project.logica.juego.reglas;

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

    protected String nombreRespuesta() {
        if (isContestada())
            return "pregunta_contestada" + ((int) (Math.random() * 3) + 1);
        return "pregunta_nocontestada" + ((int) (Math.random() * 3) + 1);
    }

    public boolean isContestada() {
        return contestada;
    }
}
