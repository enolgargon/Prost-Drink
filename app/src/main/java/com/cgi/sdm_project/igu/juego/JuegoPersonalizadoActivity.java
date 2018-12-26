package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.juego.selectores.FilteredSelector;
import com.cgi.sdm_project.logica.juego.juego.selectores.ProbabilitySelector;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;
import com.cgi.sdm_project.util.AppCompatActivityExtended;


public class JuegoPersonalizadoActivity extends AppCompatActivityExtended {
    private LinearLayout contenedor;
    private FilteredSelector filtro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegopersonalizado);

        contenedor = findViewById(R.id.layJuego);

        Juego.getInstance().setSelectorRegla(filtro = new FilteredSelector(new ProbabilitySelector()));
        cargarComponentes();
    }

    public void lanzarJuego(View vs) {
        if (filtro.isValidConfiguration()) {
            Intent mIntent = new Intent(getApplicationContext(), ElegirJugadoresActivity.class);
            startActivity(mIntent);
        } else
            Toast.makeText(this, R.string.error_personalizado, Toast.LENGTH_LONG).show();
    }

    private void cargarComponentes() {
        for (Reglas regla : Reglas.values())
            contenedor.addView(new ReglaChecker(new ContextThemeWrapper(this, R.style.BodyCondensed), regla));
    }
}
