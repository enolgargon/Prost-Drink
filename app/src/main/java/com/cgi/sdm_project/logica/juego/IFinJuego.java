package com.cgi.sdm_project.logica.juego;

import android.view.View;

public interface IFinJuego {
    /**
     * Método que prepara el juego para una nueva actividad
     *
     * @param view Vista actual con la que lanzar el siguiente
     */
    void cargarSiguienteJuego(View view);
}
