package com.cgi.sdm_project.util;

import android.content.Context;
import android.content.SharedPreferences;

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

    public boolean getPreguntas() {
        return settings.getBoolean("Preguntas", true);
    }

    public void setPreguntas(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Preguntas", opcion);
        editor.apply();
    }

    public boolean getRetos() {
        return settings.getBoolean("Retos", true);
    }

    public void setRetos(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Retos", opcion);
        editor.apply();
    }

    public boolean getYoNunca() {
        return settings.getBoolean("YoNunca", true);
    }

    public void setYoNunca(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("YoNunca", opcion);
        editor.apply();
    }

    public boolean getHastaQues() {
        return settings.getBoolean("HastaQues", true);
    }

    public void setHastaQues(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("HastaQues", opcion);
        editor.apply();
    }

    public boolean getVotaciones() {
        return settings.getBoolean("Votaciones", true);
    }

    public void setVotaciones(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Votaciones", opcion);
        editor.apply();
    }

    public boolean getFotos() {
        return settings.getBoolean("Fotos", true);
    }

    public void setFotos(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Fotos", opcion);
        editor.apply();
    }

    public boolean getTrabalenguas() {
        return settings.getBoolean("Trabalenguas", true);
    }

    public void setTrabalenguas(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Trabalenguas", opcion);
        editor.apply();
    }

    public boolean getEquilibrio() {
        return settings.getBoolean("Equilibrio", true);
    }

    public void setEquilibrio(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Equilibrio", opcion);
        editor.apply();
    }

    public boolean getCazatopos() {
        return settings.getBoolean("CazatoposActivity", true);
    }

    public void setCazatopos(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("CazatoposActivity", opcion);
        editor.apply();
    }

    public boolean getBrujula() {
        return settings.getBoolean("Brujula", true);
    }

    public void setBrujula(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Brujula", opcion);
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
