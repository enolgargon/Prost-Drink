package com.cgi.sdm_project.logica.juego.juego;

import com.cgi.sdm_project.logica.juego.reglas.Reglas;

/**
 * Interfaz que define los métodos que tienen que cumplir lo selectores de reglas.
 * Para ser un selector de reglas, se tiene que proveer de métodos para selecionar reglas... Valga la redundancia.
 *
 * @author Enol García González
 * @version 16-12-2018
 */
public interface ISelectorRegla {
    /**
     * Método que hace las operaciones aleatorias y lógicas para obtener la sieguiente actividad a la que se tienen que enfrentar los jugadores.
     *
     * @return Regla a la que se va a juagar a continuación
     */
    Reglas getSiguienteJuego();
}
