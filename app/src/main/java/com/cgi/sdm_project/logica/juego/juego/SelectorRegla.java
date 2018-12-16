package com.cgi.sdm_project.logica.juego.juego;

/**
 * Clase abstracta que facitila la implementación de selectores. Sirve únicamente para proveer a las hijas de la estructura con los tipos de juegos que se pueden usar
 */
public abstract class SelectorRegla implements ISelectorRegla {
    /**
     * Lista de juegos que hay en la aplicación
     */
    protected String[] juegos = new String[]{"Reto", "Votacion", "Pregunta", "Hastaque"};
}
