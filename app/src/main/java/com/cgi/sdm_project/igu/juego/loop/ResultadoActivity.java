package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.FinJuego;
import com.cgi.sdm_project.logica.juego.IFinJuego;

public class ResultadoActivity extends AppCompatActivity implements IFinJuego {
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultado = findViewById(R.id.txtResultado);
        resultado.setText(R.string.ResultadoEjemplo);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
    }
}