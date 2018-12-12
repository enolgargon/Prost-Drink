package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Reto;

public class RetoActivity extends AppCompatActivity implements InicioJuego {
    private Reto reto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reto);

        reto = (Reto) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.lblReto)).setText(reto.getTexto());
    }

    private void siguiente(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }

    public void atreverse(View v) {
        reto.atreverse();
        siguiente(v);
    }

    public void pasar(View v) {
        reto.pasar();
        siguiente(v);
    }

    @Override
    public void onBackPressed() {
        //Eliminar la opcion de volver hacia atrás ya que no interesa
    }
}
