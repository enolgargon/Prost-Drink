package com.cgi.sdm_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cgi.sdm_project.logica.sorteo.util.ConfigSingleton;


public class MainActivity extends AppCompatActivity {
    public static String NombrePreferencias = "Preferencias";
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniPreferences();
    }

    /**
     * Si no existen preferencias, genera unas por defecto
     */
    private void iniPreferences() {
        settings = getSharedPreferences(NombrePreferencias, Context.MODE_PRIVATE);
        if (!settings.getBoolean("Inicializado", false)){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("Inicializado", true);
            editor.putBoolean("Sonido", true);
            editor.putInt("Volumen", 100);
            editor.putInt("Idioma", 0);
            editor.commit();
        }
        ConfigSingleton.getInstancia().setPreferences(settings);
    }

    public void lanzarJuego (View vs){
        Intent mIntent = new Intent(this, JuegoActivity.class);
        startActivity(mIntent);
    }

    public void lanzarConfiguracion (View vs){
        Intent mIntent = new Intent(this, ConfiguracionActivity.class);
        startActivity(mIntent);
    }

    public void lanzarSortear (View vs){
        Intent mIntent = new Intent(this, SortearActivity.class);
        startActivity(mIntent);
    }
}
