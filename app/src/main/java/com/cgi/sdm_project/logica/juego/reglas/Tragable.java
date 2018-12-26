package com.cgi.sdm_project.logica.juego.reglas;

/**
 * Interfaz que tienen las reglas que muestran un resultado para beber.
 *
 * @author Samuel Cifuentes y Enol García González
 * @version 26-12-2018
 */
public interface Tragable extends Regla {
    /**
     * Geeter del numero de tragos
     *
     * @return Número de tragos que se bebem
     */
    int getTragos();

    /**
     * Texto que indica al usuario el número de tragos que tiene que beber
     *
     * @return Texto para mostrar al usuario
     */
    String getResultado();
}
