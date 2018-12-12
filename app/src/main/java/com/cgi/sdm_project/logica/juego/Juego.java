package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.igu.juego.loop.NotificacionActivity;
import com.cgi.sdm_project.logica.juego.reglas.Regla;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Juego {
    private static String[] juegosValidos = new String[]{"Reto", "Votacion", "Pregunta", "Hastaque"};
    private static Juego juego;

    private PriorityQueue<Notificacion> notificaciones;
    private List<Jugador> jugadores;
    private long turno;
    private Regla juegoActual;

    private Juego() {
    }

    public static Juego getInstance() {
        if (juego == null)
            juego = new Juego();
        return juego;
    }

    public List<Jugador> getJugadores() {
        return new ArrayList<Jugador>(jugadores);
    }

    public void setJugadores(List<Jugador> players) {
        jugadores = new ArrayList<Jugador>(players);
        turno = 0;
        notificaciones = new PriorityQueue<Notificacion>();
    }

    public Jugador getJugadorActual() {
        return jugadores.get((int) (turno % jugadores.size()));
    }

    public Regla getJuegoActual() {
        return juegoActual;
    }

    public long getTurnoActual() {
        return turno;
    }

    public void soliticarNotificacion(Notificacion notificacion) {
        notificaciones.offer(notificacion);
    }

    public String getNotificacion() {
        if (!notificaciones.isEmpty() && notificaciones.peek().getTurno() == turno)
            return notificaciones.poll().getMensaje();
        return "";
    }

    public Class<? extends InicioJuego> getSiguienteJuego() {
        if (!notificaciones.isEmpty() && notificaciones.peek().getTurno() == turno) {
            return NotificacionActivity.class;
        }
        String tipoPrueba = juegosValidos[(int) (Math.random() * (juegosValidos.length))];
        Regla regla = null;
        try {
            while (regla == null)
                regla = (Regla) ReglasJuego.class.getMethod("get" + tipoPrueba).invoke(ReglasJuego.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        juegoActual = regla;
        return AlmacenadorActivities.getInstance().getActivityFor(regla);
    }

    public Class<? extends InicioJuego> finalizarRonda() {
        turno++;
        return getSiguienteJuego();
    }
}
