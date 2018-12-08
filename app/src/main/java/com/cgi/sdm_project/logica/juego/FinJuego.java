package com.cgi.sdm_project.logica.juego;

import android.content.Intent;
import android.view.View;

public class FinJuego implements IFinJuego {
    @Override
    public void cargarSiguienteJuego(View view) {
        Intent i = new Intent(view.getContext(), Juego.getInstance().finalizarRonda());
        view.getContext().startActivity(i);
    }
}

