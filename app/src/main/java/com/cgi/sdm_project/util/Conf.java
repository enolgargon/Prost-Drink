package com.cgi.sdm_project.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.cgi.sdm_project.logica.juego.reglas.Reglas;
import com.cgi.sdm_project.util.singletons.AppSingleton;

public class Conf {
    //Constantes
    public static final String JUGADORES = "jugadores";
    private static Conf instancia;
    private SharedPreferences settings;

    private Conf() {
        String nombrePreferencias = "Preferencias";
        this.settings = AppSingleton.getInstance().getContext()
                .getSharedPreferences(nombrePreferencias, Context.MODE_PRIVATE);
    }

    public static Conf getInstancia() {
        if (instancia == null)
            instancia = new Conf();
        return instancia;
    }


    /******************Getters y setters*******************/
    //Sonido
    public boolean getSonido() {
        return settings.getBoolean("Sonido", true);
    }

    public void setSonido(boolean sonido) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Sonido", sonido);
        editor.apply();
    }

    //Volumen
    public int getVolumen() {
        return settings.getInt("Volumen", 100);
    }

    public void setVolumen(int volumen) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Volumen", volumen);
        editor.apply();
    }

    //Idioma
    public int getIdioma() {
        return settings.getInt("Idioma", 0);
    }

    public void setIdioma(int index) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Idioma", index);
        editor.apply();
    }

    /*Configuraciones para los tipos de juego*/

    public boolean getTipo(Reglas regla) {
        return settings.getBoolean(regla.toString(), true);
    }

    public void setTipo(Reglas regla, boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(regla.toString(), opcion);
        editor.apply();
    }

    //Guardar array
    public void saveArray(String[] array, String arrayName) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(arrayName + "_size", array.length);
        for (int i = 0; i < array.length; i++)
            editor.putString(arrayName + "_" + i, array[i]);
        editor.apply();
    }

    //Carga array
    public String[] loadArray(String arrayName) {
        int size = settings.getInt(arrayName + "_size", -1);
        if (size == -1)
            return new String[0];
        String array[] = new String[size];
        for (int i = 0; i < size; i++)
            array[i] = settings.getString(arrayName + "_" + i, null);
        return array;
    }
}
