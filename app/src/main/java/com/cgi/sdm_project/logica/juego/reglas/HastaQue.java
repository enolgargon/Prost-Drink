package com.cgi.sdm_project.logica.juego.reglas;

import android.support.annotation.NonNull;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.juego.Notificacion;
import com.cgi.sdm_project.util.AppSingleton;

public class HastaQue implements Regla {
    private final String texto;
    private final int turnos;

    public HastaQue(String texto, int turnos) {
        this.texto = texto;
        this.turnos = turnos;
    }

    public String getTexto() {
        return texto;
    }

    public int getTurnos() {
        return turnos;
    }

    public void confirmarHastaQue() {
        Juego j = Juego.getInstance();
        String mensaje = String.format(AppSingleton.getInstance().getContext().getString(R.string.notificacion_hasta_que), j.getJugadorActual().toString());
        Juego.getInstance().soliticarNotificacion(new Notificacion(j.getTurnoActual() + turnos * j.getJugadores().size(), mensaje));
    }

    @NonNull
    @Override
    public String toString() {
        return "texto:" + texto + "-turnos:" + turnos;
    }
}
