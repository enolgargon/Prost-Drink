package com.cgi.sdm_project.logica.juego.reglas.implementaciones.cazatopos;


import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cazatopos;
import com.cgi.sdm_project.util.singletons.AppSingleton;


/**
 * Implementación de la casilla que representa a los gnomos
 */
//It's gnot an elf, its gnot a gnoblin, IT'S A...
public class Gnomo extends CasillaAbstracta {
    //AND
    private static final int YOU_VE_BEEN_GNOMED = -50;

    public Gnomo(Cazatopos context, int index) {
        super(context, index);
        this.img = AppSingleton.getInstance().getDrawable(R.drawable.gnome);
        this.value = YOU_VE_BEEN_GNOMED;
    }

    @Override
    public void click() {
        super.click();
        context.getCasillas()[this.getIndex()] = new Agujero(context, this.getIndex());
    }


    @Override
    public String toString() {
        return "GNOMO";
    }
}
