package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;

public class PreguntaActivity extends AppCompatActivity implements InicioJuego {
    private Pregunta pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        pregunta = (Pregunta) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.lblPregunta)).setText(pregunta.getPregunta());
    }

    private void siguiente(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }

    public void contestar(View v) {
        pregunta.contestar();
        siguiente(v);
    }

    public void pasar(View v) {
        pregunta.pasar();
        siguiente(v);
    }
}
