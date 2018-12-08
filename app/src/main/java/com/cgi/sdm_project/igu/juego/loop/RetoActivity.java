package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Reglas.Reto;

public class RetoActivity extends AppCompatActivity implements InicioJuego {
    private static Reto reto;

    public static void setReto(Reto reto) {
        RetoActivity.reto = reto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reto);
        ((TextView) findViewById(R.id.lblReto)).setText(reto.getTexto());
    }

    public void contestar(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }
}
