package com.cgi.sdm_project.logica.juego.juego;

/**
 * Interfaz que define los métodos que tienen que cumplir lo selectores de reglas.
 * Para ser un selector de reglas, se tiene que proveer de métodos para selecionar reglas... Valga la redundancia.
 *
 * @author Enol García González
 * @version 16-12-2018
 */
public interface ISelectorRegla {
    /**
     * Método que provee del nombre de la siguiente regla de juego que se usará.
     *
     * @return Nombre de la siguiente regla de juego.
     */
    String getNombreSiguienteJuego();
}
