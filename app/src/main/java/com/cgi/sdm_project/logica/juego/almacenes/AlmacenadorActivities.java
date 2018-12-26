package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;

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

    public Class<? extends InicioJuego> getActivityFor(Reglas regla) {
        if (regla == null)
            throw new UnsupportedOperationException();
        return regla.activity();
    }
}