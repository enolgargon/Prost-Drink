package com.cgi.sdm_project.logica.juego.juego.selectores;

public class ProbabilitySelector extends BasicSelector {
    /**
     * Lista con los porcentajes de cada juego
     *
     * @see com.cgi.sdm_project.logica.juego.juego.SelectorRegla
     */
    private final int[] porcentajes = new int[]{24, 24, 24, 5, 5, 5, 5, 5, 3};

    @Override
    public String getNombreSiguienteJuego() {
        int index = 0;
        int probabilidad = (int) (Math.random() * 100);
        while ((probabilidad -= porcentajes[index]) > 0)
            index++;
        return getElementAt(index);
    }
}
