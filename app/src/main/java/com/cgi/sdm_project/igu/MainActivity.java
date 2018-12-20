package com.cgi.sdm_project.igu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.InicioJuegoActivity;
import com.cgi.sdm_project.igu.sorteo.SortearActivity;
import com.cgi.sdm_project.util.Conf;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Splash);
        setContentView(R.layout.activity_main);
        iniPreferences();
    }

    /**
     * Si no existen preferencias, genera unas por defecto
     */
    private void iniPreferences() {
        String nombrePreferencias = "Preferencias";
        SharedPreferences settings = getSharedPreferences(nombrePreferencias, Context.MODE_PRIVATE);
        if (!settings.getBoolean("Inicializado", false)) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("Inicializado", true);
            editor.putBoolean("Sonido", true);
            editor.putInt("Volumen", 100);
            editor.putInt("Idioma", 0);
            editor.apply();
        }
        Conf.getInstancia().setPreferences(settings);
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
