package com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.util.singletons.AppSingleton;

/**
 * State representando un agujero sin topo
 */
public class Agujero extends CasillaAbstracta {
    private static final int HOLE_PENALTY = -5;

    public Agujero(Cazatopos context, int index) {
        super(context, index);
        this.img = AppSingleton.getInstance().getDrawable(R.drawable.hole);
        this.value = HOLE_PENALTY;
    }

    @Override
    public String toString() {
        return "AGUJERO";
    }
}
