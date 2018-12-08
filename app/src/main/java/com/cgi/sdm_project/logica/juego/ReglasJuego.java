package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.logica.juego.Reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;
import com.cgi.sdm_project.logica.juego.Reglas.Juego;
import com.cgi.sdm_project.util.Loader;

import java.util.List;

public class ReglasJuego {

    private List<Pregunta> preguntas;
    private List<Reto> retos;
    private List<Votacion> votaciones;
    private List<Juego> juegos;
    private List<HastaQue> hastaques;

    public ReglasJuego(){
        cargarReglas();
    }

    public void cargarReglas(){
        preguntas = Loader.loadPreguntas();
        retos = Loader.loadRetos();
        votaciones = Loader.loadVotaciones();
        juegos = Loader.loadJuegos();
        hastaques = Loader.loadHastaQues();
    }

    public List<Pregunta> getPreguntas() { return preguntas; }

    public List<Reto> getRetos() { return retos; }

    public List<Votacion> getVotaciones() { return votaciones; }

    public List<Juego> getJuegos() { return juegos; }

    public List<HastaQue> getHastaques() { return hastaques; }
}
