package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.FinJuego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.YoNunca;

public class YoNuncaActivity extends Loop implements InicioJuego {

    private YoNunca yoNunca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yonunca);
        yoNunca = (YoNunca) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(R.string.grupo);
        ((TextView) findViewById(R.id.txtTextoYoNunca)).setText(yoNunca.getTexto());

    }

    public void siguiente(View v) {
        new FinJuego().cargarSiguienteJuego(v);
        finish();
    }
}
