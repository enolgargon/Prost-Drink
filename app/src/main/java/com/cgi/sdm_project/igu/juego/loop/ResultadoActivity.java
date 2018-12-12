package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.FinJuego;
import com.cgi.sdm_project.logica.juego.IFinJuego;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Tragable;

public class ResultadoActivity extends AppCompatActivity implements IFinJuego {
    public static final String REGLA = "REGLA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ((TextView) findViewById(R.id.txtResultado)).setText(((Tragable) Juego.getInstance().getJuegoActual()).getResultado());
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        new FinJuego().cargarSiguienteJuego(view);
    }

    @Override
    public void onBackPressed() {
        //Eliminar la opcion de volver hacia atrás ya que no interesa
    }
}
