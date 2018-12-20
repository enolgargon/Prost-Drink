/*
 * Enol García Gonzálezç
 * 28-10-2018
 */
package com.cgi.sdm_project.logica.sorteo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.cgi.sdm_project.util.Conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un sorteo en la aplicación. Esta clase es la encargada de almacenar la información sobre los jugadores que se quieren repartir en equipos.
 * Además implementa el algoritmo que reparte a los jugadores en equipo.
 *
 * @author Enol García Gonzálezç
 * @version 28-10-2018
 * @see Parcelable
 */
public class Sorteo implements Parcelable {
    /**
     * Creador obligatorio para recuperar los datos de un parcelable. El usuario no debe hacer nada con él. Lo utiliza android.
     *
     * @see Creator
     */
    public static final Creator<Sorteo> CREATOR = new Creator<Sorteo>() {
        @Override
        public Sorteo createFromParcel(Parcel in) {
            return new Sorteo(in);
        }

        @Override
        public Sorteo[] newArray(int size) {
            return new Sorteo[size];
        }
    };
    /**
     * Lista en la que se guardarán los jugadores para el sorteo
     */
    private final List<String> jugadores;
    /**
     * Número de equipos que se generarán con los jugadores
     */
    private int numEquipos;

    /**
     * Constructor que prepara las estructuras de datos necesarias para almacenar la información del sorteo.
     * No recibe ningún parametro porque no asigna valores. Tan solo inicializa las estructuras de datos.
     */
    public Sorteo() {
        jugadores = new ArrayList<>();
        numEquipos = 1;
        if (jugadores.size() != 0) throw new AssertionError(jugadores);
        checkInvariante();
    }

    /**
     * Constructor que crea el sorteo desde un parcelable. No se usa desde el exterior. Solo se usa por el creador interno
     *
     * @param in Objeto parcel que tiene los datos del objeto
     * @see Parcel
     */
    private Sorteo(Parcel in) {
        jugadores = in.createStringArrayList();
        numEquipos = in.readInt();
    }

    /**
     * Método que comprueba con aserciones que funciona corrrectamente.
     */
    private void checkInvariante() {
        if (numEquipos <= 0) throw new AssertionError(numEquipos);
        if (jugadores == null) throw new AssertionError("La lista de jugadores está corrupta");
    }

    /**
     * Método que añade un jugador al sorteo.
     *
     * @param nombre Nombre del jugador que se añade al sorteo
     */
    public void addJugador(String nombre) {
        if (nombre == null)
            throw new IllegalArgumentException("El nombre que se intenta introducir no es válido");
        jugadores.add(nombre);
        checkInvariante();
    }

    /**
     * Método que elimina un jugador del sorteo.
     *
     * @param indice Índice del jugador que se quiere sacar del sorteo
     */
    public void removeJugador(int indice) {
        checkInvariante();
        if (indice < 0 || indice >= jugadores.size())
            throw new IllegalArgumentException("No existe el jugador que se está intentando eliminar del sorteo");
        jugadores.remove(indice);
        checkInvariante();
    }

    /**
     * Método que devuelve el núimero de equipos configurado para generar el sorteo.
     *
     * @return Número de equipos que se van a generar con la lista de jugadores
     */
    public int getNumEquipos() {
        return numEquipos;
    }

    /**
     * Método que modifica el número de equipos que se van a generar.
     *
     * @param numEquipos Número de equipos que se quieren sortear
     * @throws IllegalArgumentException Excepción que se lanza si se intenta asignar un número de equipos 0 o negativo.
     */
    public void setNumEquipos(int numEquipos) throws IllegalArgumentException {
        if (numEquipos <= 0)
            throw new IllegalArgumentException("No puedes indicar un número de equipos 0 o negativo");
        this.numEquipos = numEquipos;
        checkInvariante();
    }

    /**
     * Método que permite obtener el número de jugadores que hay registrados para el sorteo
     *
     * @return Número de jugadores en el sorteo
     */
    public int getNumJugadores() {
        return jugadores.size();
    }

    /**
     * Método que devuelve la lista de jugadores en el sorteo.
     * <p>
     * <strong>Cuidado:</strong> La lista de jugadores se devuelve como un objeto mutable. Si se manipula indevidamente puede causar fallos en la aplicación
     * </p>
     *
     * @return Lista de jugadores registrados
     */
    public List<String> getJugadores() {
        return jugadores;
    }

    /**
     * Método que ejecuta el sorteo de grupos.
     * Esto genera una lista con un número de listas igual que el número de equipos que se quiere generar, habrá una lista para cada equipo que se genere.
     *
     * @return Lista con los grupos que se han formado. Cada grupo es una lista de nombres.
     * @throws IllegalStateException Excepción que se lanza si el número de equipos no se ha generado correctamente. Puede ser un número negativo o un número demasiado grande.
     */
    public List<List<String>> sortear() throws IllegalStateException {
        // Comprobar que el estado de las variables es correcto para hacer el sorteo
        if (numEquipos == 0)
            throw new IllegalStateException("No se ha registrado un número de equipos válido");
        if (numEquipos > jugadores.size())
            throw new IllegalStateException("No se puede sortear un número de equipos mayor que el número de jugadores registrados");

        //Guarda jugadores en las Shared Preferences
        Conf.getInstancia().saveArray(jugadores.toArray(new String[jugadores.size()]), Conf.JUGADORES);

        // Preparar las nuevas estructuras de datos para el sorteo
        List<List<String>> grupos = new ArrayList<>();
        for (int i = 0; i < numEquipos; i++) grupos.add(new ArrayList<String>());
        List<String> jugadores = new ArrayList<>(this.jugadores);
        int grupo = 0;
        Random r = new Random(System.currentTimeMillis());

        // Ejecutar el algoritmo de sortear
        while (!jugadores.isEmpty()) {
            grupos.get(grupo).add(jugadores.remove(r.nextInt(jugadores.size())));
            grupo = (++grupo) % numEquipos;
        }

        // Comprobar que la clase sorteo sigue funcionando
        checkInvariante();

        return grupos;
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sorteo{");
        sb.append("jugadores=").append(jugadores);
        sb.append(", numEquipos=").append(numEquipos);
        sb.append('}');
        sb.append('[').append(sortear()).append(']');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(jugadores);
        parcel.writeInt(numEquipos);
    }
}
