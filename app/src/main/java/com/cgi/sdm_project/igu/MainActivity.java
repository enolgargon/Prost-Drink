package com.cgi.sdm_project.igu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cgi.sdm_project.BackgroundSoundService;
import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.InicioJuegoActivity;
import com.cgi.sdm_project.igu.sorteo.SortearActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Splash);
        setContentView(R.layout.activity_main);

        //Para iniciar la música en caso de que no este a 0
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);


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
