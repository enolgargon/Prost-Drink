package com.cgi.sdm_project.util.baraja;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una baraja en el juego
 *
 * @author Enol García González
 * @version 27-12-2018
 */
public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        inicializarCartas();
    }

    /**
     * Método que crea una nueva lista de cartas.
     */
    private void inicializarCartas() {
        cartas = new ArrayList<>();

        for (Palo palo : Palo.values())
            for (int i = 1; i <= 13; i++)
                cartas.add(new Carta(i, palo));
    }

    /**
     * Método que devuelve una carta aleatoria de la baraja, pero no se elimina de la abraja y puede volver a salir.
     *
     * @return Carta aleatoria de la baraja
     */
    public Carta verCartaAleatoria() {
        return cartas.get((int) (Math.random() * cartas.size()));
    }

    /**
     * Método que devuelve una carta aleatoria de la baraja, pero además se elimina de la baraja para que no vuelva a salir.
     * Si la baraja se queda sin cartas la reinia.
     *
     * @return Carta aleatoria de la baraja, que no volverá a salir
     */
    public Carta sacarCarta() {
        Carta carta = verCartaAleatoria();
        cartas.remove(carta);
        if (cartas.isEmpty())
            inicializarCartas();
        return carta;
    }
}
