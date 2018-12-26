package com.cgi.sdm_project.logica.juego.almacenes;

import com.cgi.sdm_project.logica.juego.reglas.Regla;
import com.cgi.sdm_project.util.loaders.Loader;

import java.util.List;

/**
 * Almacen sencillo que guarda y facilita la labor de obtención de las reglas de juego.
 * Solo guarda información de un tipo de reglas
 *
 * @param <T> Tipo de reglas que se guardarán en este almacén.
 * @author Enol García González
 * @version 26-12-2018
 */
class AlmacenReglas<T extends Regla> {
    /**
     * Lista de reglas de este tipo
     */
    private List<T> elementos;

    /**
     * Método que, utilizando un cargador, carga una lista de reglas del tipo indicado para jugar
     *
     * @param loader Loader que se usará para obtener la lista de juegos
     */
    void load(Loader<T> loader) {
        elementos = loader.load();
    }

    /**
     * Método que obtiene aleatoriamente una regla del almacen
     *
     * @return Regla aleatoria obtenida del almacen
     */
    T get() {
        return elementos.get((int) (Math.random() * (elementos.size())));
    }
}
