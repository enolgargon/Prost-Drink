package com.cgi.sdm_project.igu.juego.loop.cazatopos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;

public class CazatoposInicioActivity extends Loop implements InicioJuego {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cazatopos_inicio);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
    }

    public void jugar(View view) {
        Intent intent = new Intent(this, CazatoposActivity.class);
        startActivity(intent);
        finish();
    }
}
