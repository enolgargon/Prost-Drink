package com.cgi.sdm_project.logica.juego;

import android.content.Intent;
import android.view.View;

public class FinJuego implements IFinJuego {
    @Override
    public void cargarSiguienteJuego(View view) {
        Intent i = new Intent(view.getContext(), AlmacenadorActivities.getInstance().getSiguienteActivity().getClass());
        view.getContext().startActivity(i);
    }
}
