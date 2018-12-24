package com.cgi.sdm_project.logica.juego.juego.selectores;

public class ProbabilitySelector extends BasicSelector {
    /**
     * Lista con los porcentajes de cada juego
     */
    private final int[] porcentajes = new int[]{100}/*{30, 25, 25, 10, 10}*/;

    @Override
    public String getNombreSiguienteJuego() {
        int index = 0;
        int probabilidad = (int) (Math.random() * 100);
        while ((probabilidad -= porcentajes[index]) > 0)
            index++;
        return getElementAt(index);
    }
}
