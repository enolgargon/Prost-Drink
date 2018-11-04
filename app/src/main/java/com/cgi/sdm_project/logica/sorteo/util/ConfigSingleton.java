package com.cgi.sdm_project.logica.sorteo.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.cgi.sdm_project.MainActivity;

public class ConfigSingleton {
    private static ConfigSingleton instancia;
    private SharedPreferences settings;


    public static ConfigSingleton getInstancia(){
        if (instancia == null)
            instancia = new ConfigSingleton();
        return instancia;
    }

    //Main debe pasar sus preferencias aquí
    public void setPreferences(SharedPreferences settings){
        this.settings = settings;
    }


    //Getters y setters
    public boolean getSonido(){
        return settings.getBoolean("Sonido", true);
    }


}
