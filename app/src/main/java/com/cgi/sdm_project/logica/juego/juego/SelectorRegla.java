package com.cgi.sdm_project.logica.juego.juego;

import com.cgi.sdm_project.logica.juego.reglas.Reglas;

/**
 * Clase abstracta que facitila la implementación de selectores. Sirve únicamente para proveer a las hijas de la estructura con los tipos de juegos que se pueden usar
 */
public abstract class SelectorRegla implements ISelectorRegla {
    /**
     * Método que permite obtener el juego en un índice
     *
     * @param index Indice del juego que se quiere obtener
     * @return Juego en el índice solicitado
     */
    protected Reglas getElementAt(int index) {
        return Reglas.values()[index];
    }

    protected int getNumeroJuegos() {
        return Reglas.values().length;
    }
}
