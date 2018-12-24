package com.cgi.sdm_project.igu;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.InicioJuegoActivity;
import com.cgi.sdm_project.igu.sorteo.SortearActivity;
import com.cgi.sdm_project.util.AppCompatActivityExtended;


public class MainActivity extends AppCompatActivityExtended {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Splash);
        setContentView(R.layout.activity_main);

    }

    public void lanzarJuego(View vs) {
        Intent mIntent = new Intent(this, InicioJuegoActivity.class);
        startActivity(mIntent);
    }

    public void lanzarConfiguracion(View vs) {
        Intent mIntent = new Intent(this, ConfiguracionActivity.class);
        startActivity(mIntent);
    }

    public void lanzarSortear(View vs) {
        Intent mIntent = new Intent(this, SortearActivity.class);
        startActivity(mIntent);
    }
}
