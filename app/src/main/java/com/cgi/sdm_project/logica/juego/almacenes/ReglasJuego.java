package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.logica.juego.reglas.Reglas;

import java.util.HashMap;
import java.util.Objects;

/**
 * Almacen generico de todas las reglas de juego.
 *
 * @author Samuel Cifuentes y Enol García González
 * @version 26-12-2018
 */
public class ReglasJuego {
    /**
     * Instacia única del almacenador (patron singleton)
     */
    private static ReglasJuego instance;

    /**
     * Lista de almacenes ordenador según la regla
     * Cada almacen contiene información sólo de un tipo de regla
     */
    private HashMap<Reglas, AlmacenReglas> almacenes;

    private ReglasJuego() {
        almacenes = new HashMap<>();
        cargarReglas();
    }

    /**
     * Método que obtiene la única instancia que puede existir del almacen.
     * Si no existe la crea
     *
     * @return Instancia del almacenador
     */
    public static ReglasJuego getInstance() {
        if (instance == null)
            instance = new ReglasJuego();
        return instance;
    }

    private void cargarReglas() {
        for (Reglas regla : Reglas.values())
            try {
                AlmacenReglas almacen = new AlmacenReglas();
                almacen.load(regla.loader().newInstance());
                almacenes.put(regla, almacen);
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
    }

    /**
     * Método que decuelve una regla de un tipo especificado
     *
     * @param regla Tipo de regla que se quiere obtener
     * @return Regla almacenada en el almacen
     */
    public Regla get(Reglas regla) {
        return (Regla) Objects.requireNonNull(almacenes.get(regla)).get();
    }

    /**
     * Invalida las reglas si se cambia el idioma por ejemplo
     */
    public void invalidate() {
        instance = null;
    }
}
