package com.cgi.sdm_project.logica.juego.reglas;

public class HastaQue implements Regla{
    private String texto;
    private int turnos;

    public HastaQue(String texto, int turnos){
        this.texto = texto;
        this.turnos = turnos;
    }

    public String getTexto() {
        return texto;
    }

    public int getTurnos(){ return turnos; }

    @Override
    public String toString() {
        return "texto:" + texto + "-turnos:"+turnos;
    }
}
