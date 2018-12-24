package com.cgi.sdm_project.logica.juego;

import com.cgi.sdm_project.igu.juego.loop.NotificacionActivity;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.almacenes.AlmacenadorActivities;
import com.cgi.sdm_project.logica.juego.almacenes.ReglasJuego;
import com.cgi.sdm_project.logica.juego.juego.ISelectorRegla;
import com.cgi.sdm_project.logica.juego.juego.Jugador;
import com.cgi.sdm_project.logica.juego.juego.Notificacion;
import com.cgi.sdm_project.logica.juego.juego.selectores.ProbabilitySelector;
import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.util.Conf;
import com.cgi.sdm_project.util.Enumerates.Idioma;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Clase que representa el nucleo central del juego en la aplicación.
 *
 * @author Jorge Iturrioz y Enol García González
 * @version 16-12-2018
 */
public class Juego {
    /**
     * Instancia del juego que se va a usar (patron singleton)
     */
    private static Juego juego;

    /**
     * Objeto que ofrece una estrategia para obtener el siguiente juego
     */
    private ISelectorRegla selectorRegla;
    /**
     * Cola de prioridad con las notificacions que se van a tener que mostrar al usuario
     */
    private PriorityQueue<Notificacion> notificaciones;
    /**
     * Lista de jugadores en el juego
     */
    private List<Jugador> jugadores;
    /**
     * Turno en el que se encuentra la aplicación
     */
    private long turno;
    /**
     * Regla con la que se está jugando
     */
    private Regla juegoActual;


    private Juego() {
        selectorRegla = new ProbabilitySelector();
    }

    /**
     * Método que permite obtener la instancia única del juego
     * Si no existe se crea.
     *
     * @return Instancia única del juego
     */
    public static Juego getInstance() {
        if (juego == null)
            juego = new Juego();
        return juego;
    }

    /**
     * Método que devuelve el selector de reglas que se va a usar.
     *
     * @return Selector
     */
    public ISelectorRegla getSelectorRegla() {
        return selectorRegla;
    }

    public void setSelectorRegla(ISelectorRegla selectorRegla) {
        if (selectorRegla == null)
            throw new IllegalArgumentException("No puedes establecer un selector null");
        this.selectorRegla = selectorRegla;
    }

    /**
     * Método que permite obtener la lista de jugadores
     *
     * @return Lista de jugadores que están jugando
     */
    public List<Jugador> getJugadores() {
        return new ArrayList<>(jugadores);
    }

    /**
     * Método que modifica la lista de jugadores
     *
     * @param players Nuevos jugadores
     */
    public void setJugadores(List<Jugador> players) {
        for (Jugador j : players)
            if (j == null)
                throw new IllegalArgumentException("No puede haber jugadores null.");
        jugadores = new ArrayList<>(players);
        turno = 0;
        notificaciones = new PriorityQueue<>();
    }

    /**
     * Método que obtiene el jugador actual de la ronda
     *
     * @return Jugador actual
     */
    public Jugador getJugadorActual() {
        return jugadores.get((int) (turno % jugadores.size()));
    }

    /**
     * Método que obtiene la regla del juego al que se está jugando en este momento
     *
     * @return Reglas de la actividad que se está realizando
     */
    public Regla getJuegoActual() {
        return juegoActual;
    }

    /**
     * Método que permite obtener el turno en el que se encuentra la app
     *
     * @return Número de turno actual
     */
    public long getTurnoActual() {
        return turno;
    }


    /**
     * Método que registra una nueva notificación que se le va a tener que mostrar al usuario cuando toque.
     *
     * @param notificacion Notificación que se quiere solicitar que se le muestre al usuario
     */
    public void soliticarNotificacion(Notificacion notificacion) {
        notificaciones.offer(notificacion);
    }

    /**
     * Método que saca una notificación de la cola de notificaciones siempre y cuando se deba mostrar.
     *
     * @return Notificación que hay que mostrar al usuario o null si no se tiene que mostrar ninguna
     */
    public String getNotificacion() {
        if (!notificaciones.isEmpty() && notificaciones.peek().getTurno() == turno)
            return Objects.requireNonNull(notificaciones.poll()).getMensaje();
        return "";
    }

    /**
     * Método que prepara lo necesario para el siguiente juego
     *
     * @return Clase con la activity que se le tiene que mostrar al usuario.
     */
    public Class<? extends InicioJuego> getSiguienteJuego() {
        if (notificaciones == null)
            throw new AssertionError("La lista de notificaciones está corrupta");
        if (selectorRegla == null) throw new AssertionError("No hay selector de reglas");

        if (!notificaciones.isEmpty() && notificaciones.peek().getTurno() == turno) {
            return NotificacionActivity.class;
        }

        juegoActual = null;
        String nombre;
        try {
            if ((nombre = selectorRegla.getNombreSiguienteJuego()) == null) {
                while ((nombre = selectorRegla.getNombreSiguienteJuego()) == null) ;
            }
            while ((juegoActual = (Regla) ReglasJuego.class.getMethod("get" + nombre).invoke(ReglasJuego.getInstance())) == null)
                ;

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return AlmacenadorActivities.getInstance().getActivityFor(juegoActual);
    }

    /**
     * Método que registra que se ha finalizado una ronda. Es decir que se ha terminado la acción de un jugador.
     * Esto modifica el turno para saber en que turno nos encontramos. Actualiza los jugadores y devuelve un juego para el siguiente jugador.
     *
     * @return Clase con la activity que se le tiene que mostrar al usuario.
     */
    public Class<? extends InicioJuego> finalizarRonda() {
        turno++;
        Class<? extends InicioJuego> nuevo;
        if ((nuevo = getSiguienteJuego()) == null)
            throw new AssertionError("No se ha seleccionado un nuevo juego");
        return nuevo;
    }

}
