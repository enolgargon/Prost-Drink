package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;
import com.cgi.sdm_project.util.baraja.Baraja;
import com.cgi.sdm_project.util.baraja.Carta;

import java.util.List;

/**
 * Regla para el juego de memoria con cartas
 * //TODO implementar
 *
 * @author Samuel
 */
public class Memoria extends ReglaTragable {
    /**
     * Constante que representa el número total de cartas que se usarán
     */
    public final int NUM_CARTAS = 12;

    private Baraja baraja;
    private boolean exito;

    public Memoria(int tragos) {
        super(tragos);
        baraja = new Baraja();
    }

    public void acierto() {
        exito = true;
    }

    public void fallo() {
        exito = false;
    }

    /**
     * Devuelve la lista de cartas para el juego
     * @return
     */
    public List<Carta> getCartas(){
        return baraja.dameCartas(NUM_CARTAS);
    }


    @Override
    protected String nombreRespuesta() {
        if(exito){
            return "memoria_success";
        }
        return "memoria_failure";
    }
}
