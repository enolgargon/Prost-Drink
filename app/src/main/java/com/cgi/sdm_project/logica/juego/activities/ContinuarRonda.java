package com.cgi.sdm_project.logica.juego.activities;

import android.content.Intent;
import android.view.View;

import com.cgi.sdm_project.logica.juego.Juego;

public class ContinuarRonda implements IFinJuego {
    @Override
    public void cargarSiguienteJuego(View view) {
        Intent i = new Intent(view.getContext(), Juego.getInstance().getSiguienteJuego());
        view.getContext().startActivity(i);
    }
}
