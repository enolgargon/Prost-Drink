package com.cgi.sdm_project.logica.juego.juego;

/**
 * Clase abstracta que facitila la implementación de selectores. Sirve únicamente para proveer a las hijas de la estructura con los tipos de juegos que se pueden usar
 */
public abstract class SelectorRegla implements ISelectorRegla {
    /**
     * Lista de juegos que hay en la aplicación
     */
    protected final String[] juegos = new String[]{"Reto", "Votacion", "Pregunta", "Hastaque", "Camara", "Trabalenguas", "Brujula"};

    /**
     * Método que permite obtener el juego en un índice
     *
     * @param index Indice del juego que se quiere obtener
     * @return Juego en el índice solicitado
     */
    protected String getElementAt(int index) {
        return juegos[index];
    }
}
