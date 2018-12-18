package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.logica.juego.reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.Reto;
import com.cgi.sdm_project.logica.juego.reglas.Votacion;
import com.cgi.sdm_project.util.Loader;

import java.util.List;

public class ReglasJuego {
    private static ReglasJuego instance;

    private List<Pregunta> preguntas;
    private List<Reto> retos;
    private List<Votacion> votaciones;
    private List<HastaQue> hastaques;

    private ReglasJuego() {
        cargarReglas();
    }

    public static ReglasJuego getInstance() {
        if (instance == null)
            instance = new ReglasJuego();
        return instance;
    }

    private void cargarReglas() {
        preguntas = Loader.loadPreguntas();
        retos = Loader.loadRetos();
        votaciones = Loader.loadVotaciones();
        hastaques = Loader.loadHastaQues();
    }

    public Pregunta getPregunta() {
        return preguntas.get((int) (Math.random() * (preguntas.size())));
    }

    public Reto getReto() {
        return retos.get((int) (Math.random() * (retos.size())));
    }

    public Votacion getVotacion() {
        return votaciones.get((int) (Math.random() * (votaciones.size())));
    }

    public HastaQue getHastaque() {
        return hastaques.get((int) (Math.random() * (hastaques.size())));
    }
}
