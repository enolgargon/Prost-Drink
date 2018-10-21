package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class JuegoActivity extends AppCompatActivity {

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

    public void lanzarJuegoNormal(View vs){
        Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
        startActivity(mIntent);
    }

    public void lanzarJuegoPersonalizado(View vs){
        Intent mIntent = new Intent(getApplicationContext(), JuegoPersonalizadoActivity.class);
        startActivity(mIntent);
    }
}
