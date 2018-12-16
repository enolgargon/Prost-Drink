package com.cgi.sdm_project.util;

import android.content.SharedPreferences;

public class Conf {
    private static Conf instancia;
    private SharedPreferences settings;

    private Conf() {
    }

    public static Conf getInstancia() {
        if (instancia == null)
            instancia = new Conf();
        return instancia;
    }

    //Main debe pasar sus preferencias aquí
    public void setPreferences(SharedPreferences settings) {
        this.settings = settings;
    }


    /******************Getters y setters*******************/
    //Sonido
    public boolean getSonido() {
        return settings.getBoolean("Sonido", true);
    }

    public void setSonido(boolean sonido) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Sonido", sonido);
        editor.commit();
    }

    //Volumen
    public int getVolumen() {
        return settings.getInt("Volumen", 100);
    }

    public void setVolumen(int volumen) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Volumen", volumen);
        editor.commit();
    }

    //Idioma
    public int getIdioma() {
        return settings.getInt("Idioma", 0);
    }

    public void setIdioma(int index) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Idioma", index);
        editor.commit();
    }

    /*Configuraciones para los tipos de juego*/

    public boolean getPreguntas() {
        return settings.getBoolean("Preguntas", true);
    }

    public void setPreguntas(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Preguntas", opcion);
        editor.commit();
    }

    public boolean getRetos() {
        return settings.getBoolean("Retos", true);
    }

    public void setRetos(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Retos", opcion);
        editor.commit();
    }

    public boolean getYoNunca() {
        return settings.getBoolean("YoNunca", true);
    }

    public void setYoNunca(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("YoNunca", opcion);
        editor.commit();
    }

    public boolean getHastaQues() {
        return settings.getBoolean("HastaQues", true);
    }

    public void setHastaQues(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("HastaQues", opcion);
        editor.commit();
    }

    public boolean getVotaciones() {
        return settings.getBoolean("Votaciones", true);
    }

    public void setVotaciones(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Votaciones", opcion);
        editor.commit();
    }

    /* Configuraciones para los tipos de resultados */
    public boolean getBebe() {
        return settings.getBoolean("Bebe", true);
    }

    public void setBebe(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Bebe", opcion);
        editor.commit();
    }

    public boolean getMandaBeber() {
        return settings.getBoolean("MandaBeber", true);
    }

    public void setMandaBeber(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("MandaBeber", opcion);
        editor.commit();
    }

    public boolean getCastigo() {
        return settings.getBoolean("Castigo", true);
    }

    public void setCastigo(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Castigo", opcion);
        editor.commit();
    }

    public boolean getReto() {
        return settings.getBoolean("Reto", true);
    }

    public void setReto(boolean opcion) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Reto", opcion);
        editor.commit();
    }
}
