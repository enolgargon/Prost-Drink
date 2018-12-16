package com.cgi.sdm_project.logica.juego.juego.selectores;

import com.cgi.sdm_project.logica.juego.juego.SelectorRegla;

import java.util.Arrays;

/**
 * Selector de reglas que aplica un filtro sobre las reglas.
 *
 * @author Enol García González
 * @version 16-12-2018
 */
public class FilteredSelector extends SelectorRegla {
    /**
     * Array de filtrado que indica si se va a poder usar un elemento o no
     */
    private boolean[] validos;

    public FilteredSelector() {
        validos = new boolean[juegos.length];
        Arrays.fill(validos, true);
    }

    /**
     * Método que indica si la configuración del filtrado es correcta.
     * Por el momento es correcta si hay algún elemento con el que se permite jugar.
     *
     * @return true si la configuración es válida. False en otro caso
     */
    public boolean isValidConfiguration() {
        for (boolean b : validos)
            if (b)
                return true;
        return false;
    }

    /**
     * Método que permite obtener el indice del filtrado para un tipo de regla en concreto
     *
     * @param tipo Tipo de regla que se quiere buscar en el array de filtrado
     * @return Índice que ocupa la regla en el array de filtrado
     */
    private int getIndexOf(String tipo) {
        int index;
        if ((index = Arrays.asList(juegos).indexOf(tipo)) < 0)
            throw new IllegalArgumentException("No existe el tipo de juego que quieres modificar: " + tipo);
        return index;
    }

    /**
     * Método que permite hacer que se vuelva a poder usar una regla
     *
     * @param tipo Nombre del tipo de regla que se quiere activar
     */
    public void active(String tipo) {
        validos[getIndexOf(tipo)] = true;
    }

    /**
     * Método que permite hacer que se no se pueda usar una regla
     *
     * @param tipo Nombre del tipo de regla que se quiere desactivar
     */
    public void desactive(String tipo) {
        validos[getIndexOf(tipo)] = false;
    }

    /*
     * Elige reglas aleatoriamente de entre las que se puedan elegir por el filtro.
     */
    @Override
    public String getNombreSiguienteJuego() {
        if (validos.length > juegos.length)
            throw new IllegalStateException("La lista de juegos validos es mas larga que la lista de juegos que filtrar");

        int index = -1;
        while (index < 0 || !validos[index])
            index = (int) (Math.random() * (juegos.length));

        return juegos[index];
    }
}
