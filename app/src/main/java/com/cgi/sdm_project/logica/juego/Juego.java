package com.cgi.sdm_project.logica.juego;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private static Juego juego;
    private List<Jugador> jugadores;

    private Juego(){ }

    public static Juego getInstance(){
        if (juego == null)
            juego = new Juego();
        return juego;
    }

    public void setJugadores(List<Jugador> players){
        jugadores = new ArrayList<Jugador>(players);
    }

    public List<Jugador> getJugadores(){
        return  new ArrayList<Jugador>(jugadores);
    }

    public InicioJuego getSiguienteJuego() {
        throw new UnsupportedOperationException("Esto todavía no se ha implementado");
    }
}
