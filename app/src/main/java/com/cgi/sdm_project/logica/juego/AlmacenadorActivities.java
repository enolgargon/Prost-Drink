package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.igu.juego.loop.HastaQueActivity;
import com.cgi.sdm_project.igu.juego.loop.PreguntaActivity;
import com.cgi.sdm_project.igu.juego.loop.RetoActivity;
import com.cgi.sdm_project.igu.juego.loop.VotacionActivity;
import com.cgi.sdm_project.logica.juego.reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.Reto;
import com.cgi.sdm_project.logica.juego.reglas.Votacion;
import com.cgi.sdm_project.logica.juego.reglas.Regla;

/**
 * @author Enol García González (UO257775)
 * @version 22-11-2018
 */
public class AlmacenadorActivities {
    private static AlmacenadorActivities instance;

    private AlmacenadorActivities() {

    }

    public static AlmacenadorActivities getInstance() {
        if (instance == null)
            instance = new AlmacenadorActivities();
        return instance;
    }

    public Class<? extends InicioJuego> getActivityFor(Regla regla) {
        if (regla instanceof Pregunta)
            return PreguntaActivity.class;
        else if (regla instanceof HastaQue)
            return HastaQueActivity.class;
        else if (regla instanceof Reto)
            return RetoActivity.class;
        else if (regla instanceof Votacion)
            return VotacionActivity.class;
        else if (regla instanceof Juego)
            return null;

        throw new UnsupportedOperationException();
    }
}