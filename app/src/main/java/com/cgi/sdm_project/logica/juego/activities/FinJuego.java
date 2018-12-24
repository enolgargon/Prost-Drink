package com.cgi.sdm_project.logica.juego.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.util.AppCompatActivityExtended;

public class FinJuego extends AppCompatActivityExtended implements IFinJuego {
    @Override
    public void cargarSiguienteJuego(View view) {
        Intent i = new Intent(view.getContext(), Juego.getInstance().finalizarRonda());
        view.getContext().startActivity(i);
    }
}

