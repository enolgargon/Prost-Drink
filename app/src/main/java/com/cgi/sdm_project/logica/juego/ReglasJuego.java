package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.logica.juego.Reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.Reglas.Juego;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;

import java.util.ArrayList;

public class ReglasJuego {
    private static ReglasJuego instance;

    private ArrayList<Pregunta> preguntas;
    private ArrayList<Reto> retos;
    private ArrayList<Votacion> votaciones;
    private ArrayList<Juego> juegos;
    private ArrayList<HastaQue> hastaques;

    private ReglasJuego() {

    }

    public static ReglasJuego getInstance() {
        if (instance == null)
            instance = new ReglasJuego();
        return instance;
    }

    public Pregunta getPregunta() {
        return preguntas.get((int) (Math.random() * (preguntas.size() + 1)));
    }

    public Reto getReto() {
        return retos.get((int) (Math.random() * (retos.size() + 1)));
    }

    public Votacion getVotacion() {
        return votaciones.get((int) (Math.random() * (votaciones.size() + 1)));
    }

    public Juego getJuego() {
        return juegos.get((int) (Math.random() * (juegos.size() + 1)));
    }

    public HastaQue getHastaQue() {
        return hastaques.get((int) (Math.random() * (hastaques.size() + 1)));
    }
}
