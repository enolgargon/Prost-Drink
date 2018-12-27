package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;

/**
 * Regla para el juego de memoria con cartas
 * //TODO implementar
 *
 * @author Samuel
 */
public class Memoria extends ReglaTragable {

    private boolean exito;

    public Memoria(int tragos) {
        super(tragos);
    }

    public void acierto() {
        exito = true;
    }

    public void fallo() {
        exito = false;
    }


    @Override
    protected String nombreRespuesta() {
        return null;
    }


}
