package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cgi.sdm_project.R;


public class InicioJuegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciojuego);
        attachListeners();

    }

    private void attachListeners() {
        findViewById(R.id.btnJuegoRapido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarJuegoNormal(v);
            }
        });
        findViewById(R.id.btnJuegoPersonalizado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarJuegoPersonalizado(v);
            }
        });
    }

    private void lanzarJuegoNormal(View vs){
        Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
        startActivity(mIntent);
    }

    private void lanzarJuegoPersonalizado(View vs){
        Intent mIntent = new Intent(getApplicationContext(), JuegoPersonalizadoActivity.class);
        startActivity(mIntent);
    }
}
