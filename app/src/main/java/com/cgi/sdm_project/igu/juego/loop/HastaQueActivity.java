package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.FinJuego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.HastaQue;

public class HastaQueActivity extends Loop implements InicioJuego, IFinJuego {
    private HastaQue hastaQue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_que);
        hastaQue = (HastaQue) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.lblHastaQue)).setText(hastaQue.getTexto());
    }

    public void siguiente(View v) {
        cargarSiguienteJuego(v);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        hastaQue.confirmarHastaQue();
        new FinJuego().cargarSiguienteJuego(view);
        finish();
    }
}
