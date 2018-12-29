package com.cgi.sdm_project.logica.juego.juego.selectores;

import com.cgi.sdm_project.logica.juego.reglas.Reglas;

public class ProbabilitySelector extends BasicSelector {
    @Override
    public Reglas getSiguienteJuego() {
        int index = 0;
        float probabilidad = (float) (Math.random() * 100);
        while ((probabilidad -= getElementAt(index).probabilidad()) > 0)
            index++;
        return getElementAt(index);
    }
}
