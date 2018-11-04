package com.cgi.sdm_project.logica.sorteo.util;

import android.content.SharedPreferences;

public class Conf {
    private static Conf instancia;
    private SharedPreferences settings;


    public static Conf getInstancia(){
        if (instancia == null)
            instancia = new Conf();
        return instancia;
    }

    //Main debe pasar sus preferencias aquí
    public void setPreferences(SharedPreferences settings){
        this.settings = settings;
    }


    /******************Getters y setters*******************/
    //Sonido
    public boolean getSonido(){
        return settings.getBoolean("Sonido", true);
    }

    public void setSonido(boolean sonido){
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Sonido", sonido);
        editor.commit();
    }

    //Volumen
    public int getVolumen(){
        return settings.getInt("Volumen", 100);
    }

    public void setVolumen(int volumen){
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Volumen", volumen);
        editor.commit();
    }

    //Idioma
    public int getIdioma(){
        return settings.getInt("Idioma", 0);
    }

    public void setIdioma(int index){
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Idioma", index);
        editor.commit();
    }



}
