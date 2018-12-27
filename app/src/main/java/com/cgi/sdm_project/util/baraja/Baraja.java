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
    /**
     * Constante que representa el tamaño máximo que puede tener una baraja
     */
    private final int MAX_TAM_BARAJA = 13 * 4;

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

    /**
     * Método que devuelve tantas cartas como se le piden. Si la baraja tiene menos cartas de las que se
     * piden, se reinicializa antes para garantizar que las cartas serán diferentes
     * Si pides más cartas del tamaño máximo de la baraja te casco una excepción
     *
     * @param numCartas que se quieren
     * @return
     */
    public List<Carta> dameCartas(int numCartas) {
        if (numCartas > MAX_TAM_BARAJA)
            throw new IllegalArgumentException("Adonde vas, una baraja no tiene tantas cartas");
        if (cartas.size() < numCartas) {
            inicializarCartas();
        }
        List<Carta> toRet = new ArrayList<>();
        for (int i = 0; i < numCartas; i++) {
            toRet.add(sacarCarta());
        }
        return toRet;
    }
}
