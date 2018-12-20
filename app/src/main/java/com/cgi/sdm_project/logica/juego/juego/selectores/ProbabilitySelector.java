package com.cgi.sdm_project.logica.juego.juego.selectores;

public class ProbabilitySelector extends FilteredSelector {
    /**
     * Lista con los porcentajes de cada juego
     */
    private final int[] porcentajes = new int[]{30, 25, 25, 10, 10};

    @Override
    public String getNombreSiguienteJuego() {
        String juego = null;

        while (juego == null) {
            int index = 0;
            int probabilidad = (int) (Math.random() * 100);
            while ((probabilidad -= porcentajes[index]) > 0)
                index++;
            juego = getElementAt(index);
        }

        return juego;
    }
}
