package com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos;

import android.graphics.drawable.Drawable;

import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;


/**
 * Clase abstracta para sacar factor común
 */
public abstract class CasillaAbstracta implements Casilla {
    protected int value;
    protected Drawable img;
    protected Cazatopos context;
    protected int index;

    public CasillaAbstracta(Cazatopos context, int index) {
        this.context = context;
        this.index = index;
    }

    @Override
    public void click() {
        context.updateScore(value);
    }

    @Override
    public Drawable getImg() {
        return img;
    }

    @Override
    public int getIndex() {
        return index;
    }
}
