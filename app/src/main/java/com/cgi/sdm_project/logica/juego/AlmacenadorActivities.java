package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.logica.juego.Reglas.HastaQue;
import com.cgi.sdm_project.logica.juego.Reglas.IRegla;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;

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

    public InicioJuego getActivityFor(IRegla regla) {
        if (regla instanceof Pregunta)
            return null;
        else if (regla instanceof HastaQue)
            return null;
        else if (regla instanceof Reto)
            return null;
        else if (regla instanceof Votacion)
            return null;
        else if (regla instanceof Juego)
            return null;
        throw new UnsupportedOperationException();
    }
}
