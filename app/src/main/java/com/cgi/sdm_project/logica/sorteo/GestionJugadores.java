package com.cgi.sdm_project.logica.sorteo;


import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la lógica de elegir que personas van a jugar
 *
 * @author Jorge Iturrioz
 * @version 10/11/2018 (Tarde pero al menos hecha)
 */

public class GestionJugadores {

    //TODO Hacer que la clase sea Parcelable. Se necesitará extraer un jugador de la lista de jugadores cada vez que se quiera iniciar un nuevo juego, para ello hay que pasar el obj. entre activities

    //Lista en la que se guardarán las personas que van a jugar
    private List<String> jugadores;

    public GestionJugadores(){
        jugadores = new ArrayList<String>();
    }

    public void addJugador(String nombre) {
        if (nombre == null)
            throw new IllegalArgumentException("Debe introducir un nombre válido");
        //TODO Implementar condición para no añadir elementos repetidos en caso necesario
        jugadores.add(nombre);
    }

    public void eliminarJugador(int pos){
        if (pos < 0 || pos >= jugadores.size())
            throw new IllegalArgumentException("No existe el jugador que trata de eliminar");
        jugadores.remove(pos);
    }

    /**
     * Metodo que devuelve los jugadores registrados
     * @return Devuelve una copia de la lista interna de jugadores registrados, que a su vez son únicos. Esto se hace para que no sea modificable desde fuera
     */
    public List<String> getJugadores(){
        return jugadores;
    }
}
