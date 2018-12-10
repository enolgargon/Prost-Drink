package com.cgi.sdm_project.logica.juego;

import android.util.Log;

import com.cgi.sdm_project.logica.juego.reglas.Regla;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private static String[] juegosValidos = new String[]{"Reto", "Votacion", "Pregunta"};
    private static Juego juego;

    private List<Jugador> jugadores;
    private int jugadorActual;
    private Regla juegoActual;

    private Juego() {
    }

    public static Juego getInstance() {
        if (juego == null)
            juego = new Juego();
        return juego;
    }

    public List<Jugador> getJugadores() {
        return new ArrayList<Jugador>(jugadores);
    }

    public void setJugadores(List<Jugador> players) {
        jugadores = new ArrayList<Jugador>(players);
        jugadorActual = 0;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(jugadorActual);
    }

    public Regla getJuegoActual() {
        return juegoActual;
    }

    public Class<? extends InicioJuego> getSiguienteJuego() {
        String tipoPrueba = juegosValidos[(int) (Math.random() * (juegosValidos.length))];
        Regla regla = null;
        try {
            regla = (Regla) ReglasJuego.class.getMethod("get" + tipoPrueba).invoke(ReglasJuego.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            Log.i("ENOL", e.getCause().getMessage());
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        juegoActual = regla;
        return AlmacenadorActivities.getInstance().getActivityFor(regla);
    }

    public Class<? extends InicioJuego> finalizarRonda() {
        jugadorActual = ++jugadorActual % jugadores.size();
        return getSiguienteJuego();
    }
}
