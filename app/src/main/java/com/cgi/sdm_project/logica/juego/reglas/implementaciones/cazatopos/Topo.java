package com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos;

import android.graphics.drawable.Drawable;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * State representando un agujero con topo
 */
public class Topo implements Casilla {
    private Drawable img;
    private Cazatopos context;
    private int index;

    public Topo(Cazatopos context, int index) {
        this.img = AppSingleton.getInstance().getDrawable(R.drawable.topo);
        this.context = context;
        this.index = index;
    }

    @Override
    public void click() {
        context.topoIsKill(this);
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
        return "TOPO";
    }
}
