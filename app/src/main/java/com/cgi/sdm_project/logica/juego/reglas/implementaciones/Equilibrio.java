package com.cgi.sdm_project.logica.juego.reglas.implementaciones;

import com.cgi.sdm_project.logica.juego.reglas.ReglaTragable;

public class Equilibrio extends ReglaTragable {
    private boolean respuesta;

    public Equilibrio() {
        super(3);
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void acierto() {
        respuesta = true;
    }

    public void fallo() {
        respuesta = false;
    }

    @Override
    protected String nombreRespuesta() {
        if (isRespuesta())
            return "equilibrio_exito";
        return "equilibrio_fracaso";
    }
}
