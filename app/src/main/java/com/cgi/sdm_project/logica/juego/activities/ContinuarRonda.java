package com.cgi.sdm_project.logica.juego.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.util.singletons.AppSingleton;

public class ContinuarRonda implements IFinJuego {
    @Override
    public void cargarSiguienteJuego(View view) {
        Context context = view == null ? AppSingleton.getInstance().getContext() : view.getContext();
        Intent i = new Intent(context, Juego.getInstance().getSiguienteJuego());
        context.startActivity(i);
    }
}
