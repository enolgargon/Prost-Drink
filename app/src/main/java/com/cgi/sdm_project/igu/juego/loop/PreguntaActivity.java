package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Reglas.Pregunta;

public class PreguntaActivity extends AppCompatActivity implements InicioJuego {
    private Pregunta pregunta;

    public PreguntaActivity(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        ((TextView) findViewById(R.id.lblPregunta)).setText(pregunta.getPregunta());
    }

    public void contestar(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }
}
