package com.cgi.sdm_project.igu.juego.loop.brujula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;

public class BrujulaInicioActivity extends Loop implements InicioJuego {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brujula_inicio);
    }

    public void comenzar(View view) {
        Intent intent = new Intent(this, BrujulaActivity.class);
        startActivity(intent);
        finish();
    }
}
