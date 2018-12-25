package com.cgi.sdm_project.logica.juego.reglas.cazatopos;

import android.graphics.drawable.Drawable;

/**
 * Interfaz para los states de las casillas del cazatopos
 */
public interface Casilla {
    /**
     * Define que ocurre si se hace click
     */
    void click();

    /**
     * Devuelve la imagen que se mostrará para ese tipo de casilla (topo o agujero)
     *
     * @return
     */
    Drawable getImg();

    /**
     * Devuelve el índice que ocupa la casilla en el grid lógico
     *
     * @return
     */
    int getIndex();
}
