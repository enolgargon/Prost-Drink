package com.cgi.sdm_project.logica.juego.juego;

import android.support.annotation.NonNull;

public class Notificacion implements Comparable<Notificacion> {
    private final long turno;
    private final String mensaje;

    public Notificacion(long turno, String mensaje) {
        this.turno = turno;
        this.mensaje = mensaje;
    }

    public long getTurno() {
        return turno;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public int compareTo(@NonNull Notificacion notificacion) {
        return Long.compare(turno, notificacion.getTurno());
    }
}
