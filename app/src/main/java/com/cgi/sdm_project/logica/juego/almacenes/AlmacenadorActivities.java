package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.igu.juego.loop.CamaraActivity;
import com.cgi.sdm_project.igu.juego.loop.HastaQueActivity;
import com.cgi.sdm_project.igu.juego.loop.PreguntaActivity;
import com.cgi.sdm_project.igu.juego.loop.RetoActivity;
import com.cgi.sdm_project.igu.juego.loop.TrabalenguasActivity;
import com.cgi.sdm_project.igu.juego.loop.VotacionActivity;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Camara;
import com.cgi.sdm_project.logica.juego.reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.logica.juego.reglas.Reto;
import com.cgi.sdm_project.logica.juego.reglas.Trabalenguas;
import com.cgi.sdm_project.logica.juego.reglas.Votacion;

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
        else if (regla instanceof Camara)
            return CamaraActivity.class;
        else if (regla instanceof Trabalenguas)
            return TrabalenguasActivity.class;

        throw new UnsupportedOperationException();
    }
}