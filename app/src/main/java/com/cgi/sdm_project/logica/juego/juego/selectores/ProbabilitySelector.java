package com.cgi.sdm_project.logica.juego.juego.selectores;

public class ProbabilitySelector extends BasicSelector {
    /**
     * Lista con los porcentajes de cada juego
     */
    private final int[] porcentajes = new int[]{25, 25, 25, 5, 5, 5, 5, 5};

    @Override
    public String getNombreSiguienteJuego() {
        int index = 0;
        int probabilidad = (int) (Math.random() * 100);
        while ((probabilidad -= porcentajes[index]) > 0)
            index++;
        return getElementAt(index);
    }
}
