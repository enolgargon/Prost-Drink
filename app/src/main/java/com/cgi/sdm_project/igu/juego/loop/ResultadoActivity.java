package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.FinJuego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.reglas.Tragable;

public class ResultadoActivity extends Loop implements IFinJuego {
    public static final String REGLA = "REGLA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtResultado)).setText(((Tragable) Juego.getInstance().getJuegoActual()).getResultado());
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
        finish();
    }
}
