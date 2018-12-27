package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import android.util.Log;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos.Agujero;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos.Casilla;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos.Gnomo;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos.Topo;
import com.cgi.sdm_project.util.SamUtil;

/**
 * Contexto que maneja la lógica del juego (no el loop)
 *
 * @author Samuel
 */
public class Cazatopos extends ReglaTragable {
    private int score;
    private Casilla[] casillas;

    public Cazatopos() {
        super(0);
        this.score = 0;
        this.casillas = new Casilla[6];
        actualizarTablero(1, 0);
    }

    /**
     * Actualiza y randomiza la representación lógica del tablero
     *
     * @param numTopos número de topos a introducir
     */
    public void actualizarTablero(int numTopos, int numGnomos) {
        for (int i = 0; i < casillas.length; i++) {
            if (i < numTopos) {
                casillas[i] = new Topo(this, i);
            } else if (i >= numTopos && i < numTopos + numGnomos) {
                casillas[i] = new Gnomo(this, i);
            } else
                casillas[i] = new Agujero(this, i);
        }
        casillas = SamUtil.shuffleArray(casillas);
        for (Casilla c : casillas)
            Log.i("casilla", c.toString());
    }


    /**
     * Es llamado por las casillas cuando son pulsadas
     * @param value
     */
    public void updateScore(int value) {
        score += value;
        Log.i("score", score + "");
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
     * Resetea la puntuación
     */
    public void clear() {
        score = 0;
    }


    @Override
    public int getTragos() {
        if (score <= 0) return 4;
        else if (score <= 100) return 2;
        else if (score <= 250) return 1;
        else return 3;
    }

    @Override
    protected String nombreRespuesta() {
        Log.i("score", "final score: " + score);
        if (score <= 0) {
            return "topos_resultado" + 0;
        } else if (score <= 175) {
            return "topos_resultado" + 1;
        } else if (score <= 250) {
            return "topos_resultado" + 2;
        } else {
            return "topos_resultado" + 3;
        }
    }
}
