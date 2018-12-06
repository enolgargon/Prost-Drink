package com.cgi.sdm_project.logica.juego.Reglas;

public class HastaQue extends Regla {
    private String texto;
    private int turnos;

    public HastaQue(String texto, int tragos, int turnos){
        super(tragos);
        this.texto = texto;
        this.turnos = turnos;
    }

    public String getTexto() {
        return texto;
    }

    public int getTurnos(){ return turnos; }
}
