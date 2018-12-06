package com.cgi.sdm_project.logica.juego.Reglas;

public class HastaQue {
    private String texto;
    private int tragos;
    private int turnos;

    public HastaQue(String texto, int tragos, int turnos){
        this.texto = texto;
        this.tragos = tragos;
        this.turnos = turnos;
    }

    public String getTexto() {
        return texto;
    }

    public int getTragos() {
        return tragos;
    }

    public int getTurnos(){ return turnos; }
}
