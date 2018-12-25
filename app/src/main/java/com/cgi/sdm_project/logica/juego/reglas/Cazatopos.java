package com.cgi.sdm_project.logica.juego.reglas;

import com.cgi.sdm_project.logica.juego.reglas.cazatopos.Agujero;
import com.cgi.sdm_project.logica.juego.reglas.cazatopos.Casilla;
import com.cgi.sdm_project.logica.juego.reglas.cazatopos.Topo;
import com.cgi.sdm_project.util.SamUtil;

/**
 * Contexto que maneja la lógica del juego (no el loop)
 *
 * @author Samuel
 */
public class Cazatopos implements Regla {
    private final static int TOPO_KILL = 10;
    private final static int HOLE_PENALTY = -5;
    private int score;
    private Casilla[] casillas;

    public Cazatopos() {
        this.score = 0;
        this.casillas = new Casilla[6];
        actualizarTablero(1);
    }

    /**
     * Actualiza y randomiza la representación lógica del tablero
     *
     * @param numTopos número de topos a introducir
     */
    public void actualizarTablero(int numTopos) {
        for (int i = 0; i < casillas.length; i++) {
            if (i < numTopos) {
                casillas[i] = new Topo(this, i);
            } else
                casillas[i] = new Agujero(this, i);
        }
        casillas = SamUtil.shuffleArray(casillas);
    }

    /**
     * Si se mata un topo se llama a PETA y se suman @TOPO_KILL puntos
     *
     * @param casilla
     */
    public void topoIsKill(Casilla casilla) {
        score += TOPO_KILL;
        casillas[casilla.getIndex()] = new Agujero(this, casilla.getIndex());
    }


    /**
     * Cuando se pulsa un agujero sin topo se restan @HOLE_PENALTY puntos
     */
    public void agua() {
        score -= HOLE_PENALTY;
    }

    /**
     * Devuelve el array con las casillas del juego
     *
     * @return
     */
    public Casilla[] getCasillas() {
        return casillas;
    }

    /**
     * La puntuación se usará para decidir que recompensa/castigo emplear
     *
     * @return
     */
    public int getScore() {
        return score;
    }

}
