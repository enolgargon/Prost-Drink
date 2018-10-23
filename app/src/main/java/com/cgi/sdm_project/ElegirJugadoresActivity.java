package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class ElegirJugadoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegirjugadores);

    }

    public void empezarJuego(View vs){
        Intent mIntent = new Intent(this, JuegoPreguntaActivity.class);
        startActivity(mIntent);
    }


}
