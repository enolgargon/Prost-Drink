package com.cgi.sdm_project.util.loaders;

import com.cgi.sdm_project.logica.juego.reglas.Regla;

import java.util.List;

/**
 * Interfaz básica que tienen que cumplir los cargadores de actividades. Los cargadores sólo se limitan a hacer las operaciones necesarias para devolver una lista con las actividades que el usuario puede ejecutar.
 *
 * @param <T> Tipo de regla que se va a crear
 * @author Samuel Cifuentes y Enol García González
 * @version 26-12-2018
 */
public interface Loader<T extends Regla> {
    /**
     * No necesita documentar. Carga la lista de actividades...
     *
     * @return Lista de actividades cargadas
     */
    List<T> load();
}
