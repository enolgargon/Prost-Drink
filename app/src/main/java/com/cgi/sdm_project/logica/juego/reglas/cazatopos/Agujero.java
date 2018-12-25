package com.cgi.sdm_project.logica.juego.reglas.cazatopos;

import android.graphics.drawable.Drawable;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.Cazatopos;
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * State representando un agujero sin topo
 */
public class Agujero implements Casilla {
    private Drawable img;
    private Cazatopos context;
    private int index;

    public Agujero(Cazatopos context, int index) {
        this.img = AppSingleton.getInstance().getDrawable(R.drawable.hole);
        this.context = context;
        this.index = index;
    }

    @Override
    public void click() {
        context.agua();
    }

    @Override
    public Drawable getImg() {
        return img;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "AGUJERO";
    }
}
