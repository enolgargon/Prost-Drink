package com.cgi.sdm_project.util.baraja;

import com.cgi.sdm_project.R;

/**
 * Clase que representa una carta en la aplicación
 *
 * @author Enol García González
 * @version 27-12-2018
 */
public class Carta {
    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getRes() {
        try {
            return R.drawable.class.getField(getPalo().toString() + getNumero()).getInt(R.drawable.class);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean isRed() {
        return palo.equals(Palo.CORAZONES) || palo.equals(Palo.DIAMANTES);
    }

    public boolean isEven() {
        return numero % 2 == 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Carta && ((Carta) obj).getPalo().equals(palo) && ((Carta) obj).getNumero() == numero;
    }
}
